package org.example.dto.responseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserResponseDto {
    private UUID id;
    private String date;
    private String photo;
    private String bio;
    private String name;
    private String link;
    private String phoneNumber;
    private String role;
    private List<UUID> contactsId;
}
