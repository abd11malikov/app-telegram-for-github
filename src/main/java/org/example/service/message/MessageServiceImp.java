package org.example.service.message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requestDto.MessageRequestDto;
import org.example.dto.responseDto.MessageResponseDto;
import org.example.dto.responseDto.UserResponseDto;
import org.example.model.message.MessageEntity;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImp;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MessageServiceImp implements MessageService{
    static UserService userService = new UserServiceImp();
    static ModelMapper modelMapper = new ModelMapper();
    @Override
    public boolean create(MessageRequestDto messageRequestDto) {
        if(messageRequestDto.getText()!=null){
            UserResponseDto responseDto = userService.get(messageRequestDto.getUserId());
            if (responseDto !=null){
                List<MessageEntity> data = getData();
                if (data==null) data = new ArrayList<>();
                MessageEntity message = modelMapper.map(messageRequestDto, MessageEntity.class);
                message.setId(UUID.randomUUID());
                data.add(message);
                writeData(data);

            }
        }
        return false;
    }

    @Override
    public MessageResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<MessageResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, MessageRequestDto messageRequestDto) {
        return false;
    }

    @Override
    public List<MessageEntity> getData() {
        File file = new File("data/users.json");
        Gson gson= new Gson();
        List<MessageEntity> messageEntities;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<MessageEntity>>() {}.getType();
            messageEntities = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            return null;
        }
        return messageEntities;
    }

    @Override
    public boolean writeData(List<MessageEntity> data) {
        File file = new File("data/messages.json");
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
    public MessageEntity getEntity(UUID id) {
        return null;
    }
}
