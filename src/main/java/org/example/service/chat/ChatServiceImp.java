package org.example.service.chat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requestDto.ChatRequestDto;
import org.example.dto.responseDto.ChatResponseDto;
import org.example.dto.responseDto.UserResponseDto;
import org.example.model.chat.ChatEntity;
import org.example.model.message.MessageEntity;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImp;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class ChatServiceImp implements ChatService{
    static ModelMapper modelMapper = new ModelMapper();
    static UserService userService = new UserServiceImp();

    @Override
    public boolean create(ChatRequestDto chatRequestDto) {
        UserResponseDto user1 = userService.get(chatRequestDto.getUser1Id());
        if (user1!=null){
            UserResponseDto user2 = userService.get(chatRequestDto.getUser2Id());
            if (user2!=null){
                ChatResponseDto chatResponseDto = get(chatRequestDto.getUser1Id(), chatRequestDto.getUser2Id());
                if (chatResponseDto == null){
                    ChatEntity chatEntity = new ChatEntity();
                    chatEntity.setUser1(userService.getEntity(user1.getId()));
                    chatEntity.setUser2(userService.getEntity(user2.getId()));
                    chatEntity.setDate(new Date());
                    chatEntity.setMessageEntities(new ArrayList<>());
                    chatEntity.setId(UUID.randomUUID());
                    List<ChatEntity> data = getData();
                    if (data==null) data = new ArrayList<>();
                    data.add(chatEntity);
                    writeData(data);
                }
            }
        }
        return false;
    }

    @Override
    public ChatResponseDto get(UUID id) {
        return null;
    }

    @Override
    public ChatResponseDto get(UUID user1Id, UUID user2Id) {
        List<ChatEntity> data = getData();
        if (data!=null ){
            for (ChatEntity chat : data) {
                if (chat.getUser1().getId().equals(user1Id)&&
                        chat.getUser2().getId().equals(user2Id)){
                    ChatResponseDto chatResponseDto = new ChatResponseDto();
                    chatResponseDto.setUser1Id(user1Id);
                    chatResponseDto.setUser2Id(user2Id);
                    List<UUID> messagesId = new ArrayList<>();
                    for (MessageEntity messageEntity : chat.getMessageEntities()) {
                        messagesId.add(messageEntity.getId());
                    }
                    chatResponseDto.setMessagesId(messagesId);
                }if (chat.getUser2().getId().equals(user1Id)&&
                        chat.getUser1().getId().equals(user2Id)){
                    ChatResponseDto chatResponseDto = new ChatResponseDto();
                    chatResponseDto.setUser1Id(user1Id);
                    chatResponseDto.setUser2Id(user2Id);
                    List<UUID> messagesId = new ArrayList<>();
                    for (MessageEntity messageEntity : chat.getMessageEntities()) {
                        messagesId.add(messageEntity.getId());
                    }
                    chatResponseDto.setMessagesId(messagesId);
                }
            }
        }return null;
    }

    @Override
    public List<ChatResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, ChatRequestDto chatRequestDto) {
        return false;
    }

    @Override
    public List<ChatEntity> getData() {
        File file = new File("data/chats.json");
        Gson gson= new Gson();
        List<ChatEntity> users;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<ChatEntity>>() {}.getType();
            users = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            return null;
        }
        return users;
    }

    @Override
    public boolean writeData(List<ChatEntity> data) {
        File file = new File("data/chats.json");
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
    public ChatEntity getEntity(UUID id) {
        return null;
    }
}
