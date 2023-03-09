package org.example.model;

import enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.base.BaseModel;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoleTable extends BaseModel {
    private UUID userId;
    private UUID channelId;
    private Role role;
}
