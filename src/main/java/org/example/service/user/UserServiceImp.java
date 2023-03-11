package org.example.service.user;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requestDto.UserRequestDto;
import org.example.dto.responseDto.UserResponseDto;
import org.example.enums.Role;
import org.example.model.user.UserEntity;
import org.modelmapper.ModelMapper;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class UserServiceImp implements UserService {

    static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserResponseDto get(String phoneNumber) {
        List<UserEntity> data = getData();
        if (data!=null){
            for (UserEntity user : data) {
                if (user.getPhoneNumber().equals(phoneNumber))
                    return modelMapper.map(user, UserResponseDto.class);
            }
        }return null;
    }

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
                    user.setId(UUID.randomUUID());
                    user.setRole(Role.USER);
                    user.setContact(new ArrayList<>());
                    user.setDate(new Date());
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
        List<UserEntity> userEntityList = getData();
        if (userEntityList != null){
            for (UserEntity userEntity : userEntityList) {
                if (userEntity.getId().equals(id)){
                    return modelMapper.map(userEntity, UserResponseDto.class);
                }
            }
        }
        return null;
    }

    @Override
    public List<UserResponseDto> getList() {
        List<UserEntity> userEntityList = getData();
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        if (userEntityList != null){
            for (UserEntity userEntity : userEntityList) {
                UserResponseDto userResponseDto = modelMapper.map(userEntity, UserResponseDto.class);
                userResponseDtoList.add(userResponseDto);
            }
            return userResponseDtoList;
        }
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<UserEntity> data = getData();
        if (data != null){
            for (UserEntity datum : data) {
                if (datum.getId().equals(id)){
                    data.remove(datum);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(UUID id, UserRequestDto userRequestDto) {
        List<UserEntity> userEntities = getData();
        if (userEntities != null){
            for (UserEntity userEntity : userEntities) {
                if (userEntity.getId().equals(id)){
                    userEntities.remove(userEntity);
                    modelMapper.map(userRequestDto,userEntity);
                    userEntities.add(userEntity);
                    writeData(userEntities);
                    return true;
                }
            }
        }
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
        File file = new File("data/users.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            String json = gson.toJson(data);
            bufferedWriter.write(json);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public UserEntity getEntity(UUID id) {
        List<UserEntity> data = getData();
        if (data != null){
            for (UserEntity datum : data) {
                if (datum.getId().equals(id))return datum;
            }
        }
        return null;
    }

}
