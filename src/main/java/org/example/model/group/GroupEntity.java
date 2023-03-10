package org.example.model.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.base.BaseUGC;
import org.example.model.message.Message;
import org.example.model.user.UserEntity;


import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupEntity extends BaseUGC {
    private List<Message> messages;
    private List<UserEntity> members;
}
