package model.message;

import enums.MessageState;
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
public class Table extends BaseModel {
    private UUID messageId;
    private UUID userId;
    private MessageState state;
}
