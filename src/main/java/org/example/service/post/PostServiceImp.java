package org.example.service.post;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requestDto.PostRequestDto;
import org.example.dto.responseDto.PostResponseDto;
import org.example.model.channel.PostEntity;
import org.example.model.message.MessageEntity;
import org.example.service.message.MessageService;
import org.example.service.message.MessageServiceImp;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PostServiceImp implements PostService{
    static MessageService messageService = new MessageServiceImp();
    static ModelMapper modelMapper = new ModelMapper();
    @Override
    public boolean create(PostRequestDto postRequestDto) {
        if (postRequestDto.getMessageRequestDto() != null){
            boolean result = messageService.create(postRequestDto.getMessageRequestDto());
            if (result){
                PostEntity post = modelMapper.map(postRequestDto, PostEntity.class);
                post.setId(UUID.randomUUID());
                post.setComment(new ArrayList<>());
                post.setViews(new ArrayList<>());
                post.setDate(new Date());
                MessageEntity messageEntity = modelMapper.map(postRequestDto.getMessageRequestDto(), MessageEntity.class);
                post.setMessageEntity(messageEntity);
                List<PostEntity> data = getData();if (data==null)data=new ArrayList<>();
                data.add(post);
                writeData(data);
                return true;
            }
        }
        return false;
    }

    @Override
    public PostResponseDto get(UUID id) {
        List<PostEntity> data = getData();
        if (data != null){
            for (PostEntity datum : data) {
                if (datum.getId().equals(id)){
                    return modelMapper.map(datum,PostResponseDto.class);

                }
            }
        }
        return null;
    }

    @Override
    public List<PostResponseDto> getList() {
        List<PostEntity> data = getData();
        if (data != null){
            List<PostResponseDto> postResponseDto=new ArrayList<>();
            for (PostEntity datum : data) {
                postResponseDto.add(modelMapper.map(datum,PostResponseDto.class));
            }
            return postResponseDto;
        }
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<PostEntity> data = getData();
        if (data != null){
            for (PostEntity datum : data) {
                if (datum.getId().equals(id)){
                    data.remove(datum);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(UUID id, PostRequestDto postRequestDto) {
        List<PostEntity> data = getData();
        if (data != null){
            for (PostEntity datum : data) {
                if (datum.getId().equals(id)){
                    data.remove(datum);
                    modelMapper.map(postRequestDto,datum);
                    data.add(datum);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<PostEntity> getData() {
        File file = new File("data/posts.json");
        Gson gson= new Gson();
        List<PostEntity> posts;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<PostEntity>>() {}.getType();
            posts = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            return null;
        }
        return posts;
    }

    @Override
    public boolean writeData(List<PostEntity> data) {
        File file = new File("data/posts.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            String json = gson.toJson(data);
            bufferedWriter.write(json);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public PostEntity getEntity(UUID id) {
        List<PostEntity> data = getData();
        if (data != null){
            for (PostEntity datum : data) {
                if (datum.getId().equals(id)){
                    return datum;
                }
            }
        }
        return null;
    }
}
