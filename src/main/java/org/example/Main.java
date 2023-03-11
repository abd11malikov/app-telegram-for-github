package org.example;

import org.example.dto.requestDto.*;
import org.example.dto.responseDto.UserResponseDto;
import org.example.front.ChatFront;
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
        MessageRequestDto messageRequestDto = new MessageRequestDto();
        messageRequestDto.setText("sdjfgdghj");
        messageRequestDto.setUserId(userService.getData().get(0).getId());
        messageService.create(messageRequestDto);
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
        System.out.print(ENTER_PHONE_NUMBER);
        String phoneNumber = scannerStr.nextLine();
        System.out.print("Enter password : ");
        String password=scannerStr.nextLine();
        System.out.print("Enter name : ");
        String name = scannerStr.nextLine();
        UserRequestDto userRequestDto=UserRequestDto.builder()
                .phoneNumber(phoneNumber).password(password).name(name)
                .build();
        boolean result = userService.create(userRequestDto);
        if (result){
            System.out.println(SUCCESSFULLY_COMPLETED);
        }else System.out.println(ERROR);
    }


    private static void signIn() {
        System.out.print(ENTER_PHONE_NUMBER);
        String phoneNumber = scannerStr.nextLine();
        UserResponseDto responseDto = userService.get(phoneNumber);
        if (responseDto != null){
            System.out.print("Enter password");
            String password = scannerStr.nextLine();
            if (password.equals(responseDto.getPassword())){
                userPage(responseDto);
            }
        }

    }

    private static void userPage(UserResponseDto responseDto) {
        while (true){
            System.out.println(USER_PAGE);
            int option = scannerInt.nextInt();
            if (option == 0) break;
            switch (option){
                case 1 -> ChatFront.chats(responseDto);
                case 2 -> System.out.print("");
                case 3 -> System.out.print(" ");
                case 4 -> System.out.print(" ");
            }
        }
    }
}
