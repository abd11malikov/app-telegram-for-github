package org.example.service.message;
import org.example.dto.requestDto.MessageRequestDto;
import org.example.dto.responseDto.MessageResponseDto;
import org.example.dto.responseDto.UserResponseDto;
import org.example.model.message.Message;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImp;

import java.util.List;
import java.util.UUID;

public class MessageServiceImp implements MessageService{
    static UserService userService = new UserServiceImp();
    @Override
    public boolean create(MessageRequestDto messageRequestDto) {
        if(messageRequestDto.getText()!=null){
            UserResponseDto responseDto = userService.get(messageRequestDto.getUserId());
            if (responseDto !=null){

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
    public List<Message> getData() {
        return null;
    }

    @Override
    public boolean writeData(List<Message> data) {
        return false;
    }

    @Override
    public Message getEntity(UUID id) {
        return null;
    }
}
