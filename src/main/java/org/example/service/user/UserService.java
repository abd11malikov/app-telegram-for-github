package service.user;

import dto.requestDto.UserRequestDto;
import dto.responseDto.UserResponseDto;
import model.user.UserEntity;
import service.BaseService;

public interface UserService extends BaseService<UserRequestDto, UserResponseDto, UserEntity> {
}
