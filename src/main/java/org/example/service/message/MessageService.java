package org.example.service.message;

import org.example.dto.requestDto.MessageRequestDto;
import org.example.dto.responseDto.MessageResponseDto;
import org.example.model.message.MessageEntity;
import org.example.model.message.Table;
import org.example.service.BaseService;

import java.util.List;

public interface MessageService extends BaseService<MessageRequestDto, MessageResponseDto, MessageEntity> {
    boolean writeMessagesData(List<Table> messages);

    boolean getMessagesData();
}
