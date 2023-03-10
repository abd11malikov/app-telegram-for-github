package org.example.model.message;

import org.example.enums.MessageState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.base.BaseModel;
import org.example.model.user.UserEntity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity extends BaseModel {
    private UserEntity user;
    private String text;
    private MessageState messageState;
}
