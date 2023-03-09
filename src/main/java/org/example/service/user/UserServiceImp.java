package service.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.requestDto.UserRequestDto;
import dto.responseDto.UserResponseDto;
import model.user.UserEntity;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserServiceImp implements UserService {

    static final ModelMapper modelMapper = new ModelMapper();
    @Override
    public boolean create(UserRequestDto userRequestDto) {
        if (userRequestDto.getName()!=null){
            if (userRequestDto.getLink()!=null){
                if (userRequestDto.getPhoneNumber()!=null){
                    List<UserEntity> data = getData();
                    if (data==null) data = new ArrayList<>();
                    for (UserEntity user : data) {
                        if (user.getPhoneNumber().equals(userRequestDto.getPhoneNumber())) return false;
                        if (user.getLink().equals(userRequestDto.getLink())) return false;
                    }
                    UserEntity user = modelMapper.map(userRequestDto, UserEntity.class);
                    data.add(user);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public UserResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<UserResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, UserRequestDto userRequestDto) {
        return false;
    }

    @Override
    public List<UserEntity> getData() {
        File file = new File("data/users.json");
        Gson gson= new Gson();
        List<UserEntity> users;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<UserEntity>>() {}.getType();
            users = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            return null;
        }
        return users;
    }

    @Override
    public boolean writeData(List<UserEntity> data) {
        return false;
    }

    @Override
    public UserEntity getEntity(UUID id) {
        return null;
    }
}
