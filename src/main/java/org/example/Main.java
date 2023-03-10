package org.example;

import org.example.dto.requestDto.ChannelRequestDto;
import org.example.dto.requestDto.GroupRequestDto;
import org.example.dto.requestDto.MessageRequestDto;
import org.example.dto.requestDto.PostRequestDto;
import org.example.service.channel.ChannelService;
import org.example.service.channel.ChannelServiceImp;
import org.example.service.group.GroupService;
import org.example.service.group.GroupServiceImp;
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
    static ChannelService channelService = new ChannelServiceImp();
    static GroupService groupService = new GroupServiceImp();
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
        ChannelRequestDto channelRequestDto = ChannelRequestDto.builder()
                .bio("You are yourself")
                .link("linkedin")
                .name("channelN1")
                .build();
        channelService.create(channelRequestDto);
        GroupRequestDto groupRequestDto = GroupRequestDto.builder()
                .name("fghjk")
                .link("fghj")
                .build();
        groupService.create(groupRequestDto);
    }
}
