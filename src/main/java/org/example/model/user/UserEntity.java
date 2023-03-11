package org.example.model.user;

import lombok.*;

import org.example.enums.Role;
import org.example.model.base.BaseUGC;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseUGC {
    private String phoneNumber;
    private Role role;
    private String password;
    private List<UserEntity> contact;
}
