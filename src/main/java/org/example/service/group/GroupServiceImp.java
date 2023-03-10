package org.example.service.group;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requestDto.GroupRequestDto;
import org.example.dto.responseDto.GroupResponseDto;
import org.example.model.channel.ChannelEntity;
import org.example.model.channel.PostEntity;
import org.example.model.group.GroupEntity;
import org.example.model.user.UserEntity;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class GroupServiceImp implements GroupService {
    static ModelMapper modelMapper = new ModelMapper();
    @Override
    public boolean create(GroupRequestDto groupRequestDto) {
        if(groupRequestDto.getLink()!=null)
            if (groupRequestDto.getName()!=null){
                List<GroupEntity> data = getData();
                if (data==null) data= new ArrayList<>();
                for (GroupEntity channel : data) {
                    if (channel.getLink().equals(groupRequestDto.getLink())) return false;
                }
                GroupEntity channel = modelMapper.map(groupRequestDto, GroupEntity.class);
                channel.setId(UUID.randomUUID());
                channel.setMembers(new ArrayList<>());
                channel.setDate(new Date());
                channel.setMessageEntities(new ArrayList<>());
                data.add(channel);
                writeData(data);
                return true;
            }
        return false;
    }

    @Override
    public GroupResponseDto get(UUID id) {
        List<GroupEntity> data = getData();
        if (data != null){
            for (GroupEntity datum : data) {
                if (datum.getId().equals(id)){
                    return modelMapper.map(datum, GroupResponseDto.class);
                }
            }
        }
        return null;
    }

    @Override
    public List<GroupResponseDto> getList() {
        List<GroupEntity> data = getData();
        if (data != null){
            List<GroupResponseDto> groupResponseDto=new ArrayList<>();
            for (GroupEntity datum : data) {
                groupResponseDto.add(modelMapper.map(datum, GroupResponseDto.class));
            }
            return groupResponseDto;
        }
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<GroupEntity> data = getData();
        if (data != null){
            for (GroupEntity datum : data) {
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
    public boolean update(UUID id, GroupRequestDto groupRequestDto) {
        List<GroupEntity> data = getData();
        if (data != null){
            for (GroupEntity datum : data) {
                if (datum.getId().equals(id)){
                    data.remove(datum);
                    modelMapper.map(groupRequestDto,datum);
                    data.add(datum);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<GroupEntity> getData() {
        File file = new File("data/groups.json");
        Gson gson= new Gson();
        List<GroupEntity> users;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<GroupEntity>>() {}.getType();
            users = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            return null;
        }
        return users;
    }

    @Override
    public boolean writeData(List<GroupEntity> data) {
        File file = new File("data/groups.json");
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
    public GroupEntity getEntity(UUID id) {
        List<GroupEntity> data = getData();
        if (data != null){
            for (GroupEntity datum : data) {
                if (datum.getId().equals(id)){
                    return datum;
                }
            }
        }
        return null;
    }
}
