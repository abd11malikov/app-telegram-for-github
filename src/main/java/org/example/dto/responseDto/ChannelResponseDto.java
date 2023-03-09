package org.example.dto.responseDto;

import lombok.*;
import java.util.List;
import java.util.UUID;
@Builder@Getter@NoArgsConstructor@Setter@AllArgsConstructor
public class ChannelResponseDto {
    private UUID id;
    private String photo;
    private String bio;
    private String name;
    private String link;
    private List<UUID> possId;
    private List<UUID> membersId;
}
