package org.example.model.channel;

import enums.MessageState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.base.BaseModel;
import org.example.model.message.Message;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseModel {
    private List<Message> comment;
    private MessageState state;
    private List<UUID> views;
    private Message message;
}
