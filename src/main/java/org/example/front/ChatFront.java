package org.example.front;

import org.example.Constant;
import org.example.dto.responseDto.ChatResponseDto;
import org.example.dto.responseDto.UserResponseDto;
import org.example.service.chat.ChatService;
import org.example.service.chat.ChatServiceImp;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImp;

import java.util.List;
import java.util.Scanner;

public class ChatFront implements Constant {
    static Scanner scannerInt=new Scanner(System.in);
    static Scanner scannerStr=new Scanner(System.in);
    static UserService userService = new UserServiceImp();
    static ChatService chatService = new ChatServiceImp();
    public static void chats(UserResponseDto userResponseDto){
        while (true){
            System.out.println(CHAT_PAGE);
            int option = scannerInt.nextInt();
            if (option==0) break;
            else if (option ==1) chatList(userResponseDto);
        }

    }

    private static void chatList(UserResponseDto userResponseDto) {

    }
}
