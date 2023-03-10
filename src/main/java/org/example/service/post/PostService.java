package org.example.service.post;

import org.example.dto.requestDto.PostRequestDto;
import org.example.dto.responseDto.PostResponseDto;
import org.example.model.channel.PostEntity;
import org.example.service.BaseService;

public interface PostService extends BaseService<PostRequestDto, PostResponseDto, PostEntity> {
}
