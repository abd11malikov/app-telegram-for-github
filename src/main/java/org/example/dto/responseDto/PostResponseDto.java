package org.example.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@
        Setter
@
        NoArgsConstructor
@
        AllArgsConstructor
@
        Getter
public class PostResponseDto {

    private List<UUID> commentsId;
    private String state;
    private List<UUID> views;
    private UUID messageId;
}
