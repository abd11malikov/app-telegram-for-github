package org.example.model.message;

import org.example.enums.MessageState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.base.BaseModel;

import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Table extends BaseModel {
    private UUID messageId;
    private UUID userId;
    private MessageState state;
}
