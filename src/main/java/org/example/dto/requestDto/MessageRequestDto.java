package org.example.dto.requestDto;

import lombok.*;

import java.util.UUID;
@NoArgsConstructor@AllArgsConstructor
@Getter
@Setter
@Builder
public class MessageRequestDto {
    private UUID userId;
    private String text;
}
