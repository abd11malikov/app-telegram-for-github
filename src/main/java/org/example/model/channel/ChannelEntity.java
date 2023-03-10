package org.example.model.channel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.base.BaseUGC;
import org.example.model.user.UserEntity;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelEntity extends BaseUGC {
    private List<PostEntity> postEntity;
    private List<UserEntity> members;

}
