package org.example.service.channel;

import org.example.dto.requestDto.ChannelRequestDto;
import org.example.dto.responseDto.ChannelResponseDto;
import org.example.model.channel.ChannelEntity;
import org.example.service.BaseService;

import java.util.List;
import java.util.UUID;

public class ChannelServiceImp implements ChannelService {
    @Override
    public boolean create(ChannelRequestDto channelRequestDto) {

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
        return null;
    }

    @Override
    public boolean writeData(List<ChannelEntity> data) {
        return false;
    }

    @Override
    public ChannelEntity getEntity(UUID id) {
        return null;
    }
}
