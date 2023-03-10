package org.example;

import org.example.dto.requestDto.*;
import org.example.service.channel.ChannelService;
import org.example.service.channel.ChannelServiceImp;
import org.example.service.chat.ChatService;
import org.example.service.chat.ChatServiceImp;
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
    static ChatService chatService = new ChatServiceImp();
    public static void main(String[] args) {

    }
}
