package org.example.dto.requestDto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
    private String name;
    private String link;
    private String phoneNumber;
    private String password;
}
