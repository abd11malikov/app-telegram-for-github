package org.example.service.channel;

import org.example.dto.requestDto.ChannelRequestDto;
import org.example.dto.responseDto.ChannelResponseDto;
import org.example.dto.responseDto.ChatResponseDto;
import org.example.model.RoleTable;
import org.example.model.channel.ChannelEntity;
import org.example.service.BaseService;

import java.util.List;
import java.util.UUID;

public interface ChannelService extends BaseService<ChannelRequestDto, ChannelResponseDto, ChannelEntity> {
    boolean writeTable(List<RoleTable> roleTables);
    List<RoleTable> getTable();
}
