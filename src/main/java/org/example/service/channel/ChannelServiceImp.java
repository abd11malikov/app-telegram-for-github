package org.example.service.channel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requestDto.ChannelRequestDto;
import org.example.dto.responseDto.ChannelResponseDto;
import org.example.model.channel.ChannelEntity;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImp;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ChannelServiceImp implements ChannelService {
    static ModelMapper modelMapper = new ModelMapper();
    static UserService userService = new UserServiceImp();
    @Override
    public boolean create(ChannelRequestDto channelRequestDto) {
        if(channelRequestDto.getLink()!=null)
            if (channelRequestDto.getName()!=null){
                List<ChannelEntity> data = getData();
                if (data==null) data= new ArrayList<>();
                for (ChannelEntity channel : data) {
                    if (channel.getLink().equals(channelRequestDto.getLink())) return false;
                }
                ChannelEntity channel = modelMapper.map(channelRequestDto, ChannelEntity.class);
                channel.setId(UUID.randomUUID());
                channel.setMembers(new ArrayList<>());
                channel.setDate(new Date());
                channel.setPostEntity(new ArrayList<>());
                data.add(channel);
                writeData(data);
            }
        return false;
    }

    @Override
    public ChannelResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<ChannelResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, ChannelRequestDto channelRequestDto) {
        return false;
    }

    @Override
    public List<ChannelEntity> getData() {
        File file = new File("data/channels.json");
        Gson gson= new Gson();
        List<ChannelEntity> channelEntityList;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<ChannelEntity>>() {}.getType();
            channelEntityList = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            return null;
        }
        return channelEntityList;
    }

    @Override
    public boolean writeData(List<ChannelEntity> data) {
        File file = new File("data/channels.json");
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
    public ChannelEntity getEntity(UUID id) {
        return null;
    }
}
