package model.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.base.BaseModel;
import model.message.Message;
import model.user.UserEntity;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatEntity extends BaseModel {
    private UserEntity user1;
    private UserEntity user2;
    private List<Message> messages;
}
