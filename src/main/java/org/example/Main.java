package org.example;

import org.example.dto.requestDto.*;
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

import java.util.Scanner;

public class Main implements Constant{

    static Scanner scannerInt=new Scanner(System.in);
    static Scanner scannerStr=new Scanner(System.in);

    static UserService userService = new UserServiceImp();
    static MessageService messageService = new MessageServiceImp();
    static PostService postService = new PostServiceImp();
    static ChannelService channelService = new ChannelServiceImp();
    static GroupService groupService = new GroupServiceImp();


    public static void main(String[] args) {
        while (true){
            System.out.println(ENTRANCE);
            int option= scannerInt.nextInt();
            if (option == 0)   break;
            else if (option == 1)   signUp();
            else if (option == 2)   signIn();
            else System.out.println(WRONG_OPTION);
        }
    }


    private static void signUp() {
        System.out.println(ENTER_PHONE_NUMBER);
        String phoneNumber = scannerStr.nextLine();
        System.out.println("Enter password : ");
        String password=scannerStr.nextLine();
        UserRequestDto userRequestDto=UserRequestDto.builder()
                .phoneNumber(phoneNumber).password(password)
                .build();
        boolean result = userService.create(userRequestDto);
        if (result){
            System.out.println(SUCCESSFULLY_COMPLETED);
        }else System.out.println(ERROR);

    }


    private static void signIn() {
    }
}
