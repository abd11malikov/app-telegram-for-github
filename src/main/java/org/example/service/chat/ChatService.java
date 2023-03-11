package org.example.service.chat;

import org.example.dto.requestDto.ChatRequestDto;
import org.example.dto.responseDto.ChatResponseDto;
import org.example.model.RoleTable;
import org.example.model.chat.ChatEntity;
import org.example.service.BaseService;

import java.util.List;
import java.util.UUID;

public interface ChatService extends BaseService<ChatRequestDto, ChatResponseDto , ChatEntity> {
    ChatResponseDto get(UUID user1Id, UUID user2Id);

}
