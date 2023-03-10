package org.example;

import org.example.dto.requestDto.UserRequestDto;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImp;

public class Main {
    static UserService userService = new UserServiceImp();
    public static void main(String[] args) {
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .link("abd11malikov01")
                .name("Abdumalikov")
                .phoneNumber("+998931610329")
                .build();
        userService.create(userRequestDto) ;
    }
}
