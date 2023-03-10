package org.example.service.message;

import org.example.dto.requestDto.MessageRequestDto;
import org.example.dto.responseDto.MessageResponseDto;
import org.example.model.message.Message;
import org.example.service.BaseService;

public interface MessageService extends BaseService<MessageRequestDto, MessageResponseDto, Message> {
}
