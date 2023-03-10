package org.example;

import org.example.dto.requestDto.MessageRequestDto;
import org.example.dto.requestDto.UserRequestDto;
import org.example.service.message.MessageService;
import org.example.service.message.MessageServiceImp;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImp;

public class Main {
    static UserService userService = new UserServiceImp();
    static MessageService messageService = new MessageServiceImp();
    public static void main(String[] args) {
        UserRequestDto userRequestDto =UserRequestDto.builder()
                .link("dfgh")
                .name("fgfd")
                .phoneNumber("dsdfsd")
                .build();
        userService.create(userRequestDto);
        MessageRequestDto messageRequestDto = MessageRequestDto.builder()
                .text("ksdjhfkd")
                .userId(userService.getData().get(0).getId())
                .build();
        messageService.create(messageRequestDto);
    }
}
