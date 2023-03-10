package org.example.dto.responseDto;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MessageResponseDto {
    private UUID userId;
    private String text;
    private String state;
}
