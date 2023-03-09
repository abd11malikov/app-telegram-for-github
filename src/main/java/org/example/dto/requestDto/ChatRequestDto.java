package org.example.dto.requestDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class ChatRequestDto {
    private UUID user1Id;
    private UUID user2Id;
    private List<UUID> messagesId;
}
