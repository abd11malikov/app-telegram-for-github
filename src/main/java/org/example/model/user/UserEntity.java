package org.example.model.user;

import enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.base.BaseModel;
import model.base.BaseUGC;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseUGC {
    private String phoneNumber;
    private Role role;
    private List<UserEntity> contact;
}
