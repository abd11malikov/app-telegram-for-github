package org.example.dto.requestDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MessageRequestDto {
    private UUID userId;
    private String text;
}
