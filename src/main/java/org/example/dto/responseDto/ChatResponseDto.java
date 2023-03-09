package org.example.dto.responseDto;

import lombok.*;

import java.util.List;
import java.util.UUID;
@NoArgsConstructor@AllArgsConstructor@Getter@Setter
public class ChatResponseDto {
    private UUID user1Id;
    private UUID user2Id;
    private List<UUID> messagesId;
}
