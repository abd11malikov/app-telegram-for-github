package org.example.dto.responseDto;

import java.util.List;
import java.util.UUID;

public class GroupResponseDto {
    private UUID id;
    private String photo;
    private String bio;
    private String name;
    private String link;
    private List<UUID> possId;
    private List<UUID> membersId;
}
