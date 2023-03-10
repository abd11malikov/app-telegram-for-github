package org.example.service.user;


import org.example.dto.requestDto.UserRequestDto;
import org.example.dto.responseDto.UserResponseDto;
import org.example.model.user.UserEntity;
import org.example.service.BaseService;

public interface UserService extends BaseService<UserRequestDto, UserResponseDto, UserEntity> {



}
