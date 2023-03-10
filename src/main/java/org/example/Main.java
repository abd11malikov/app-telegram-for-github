package org.example;

import org.example.dto.requestDto.MessageRequestDto;
import org.example.dto.requestDto.PostRequestDto;
import org.example.dto.requestDto.UserRequestDto;
import org.example.service.message.MessageService;
import org.example.service.message.MessageServiceImp;
import org.example.service.post.PostService;
import org.example.service.post.PostServiceImp;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImp;

public class Main {
    static UserService userService = new UserServiceImp();
    static MessageService messageService = new MessageServiceImp();
    static PostService postService = new PostServiceImp();
    public static void main(String[] args) {
        MessageRequestDto messageRequestDto = MessageRequestDto.builder()
                .text("sdfdsf")
                .userId(userService.getData().get(0).getId())
                .build();
        messageService.create(messageRequestDto);
        PostRequestDto postRequestDto = PostRequestDto.builder()
                .messageRequestDto(messageRequestDto)
                .build();
        postService.create(postRequestDto);
    }
}
