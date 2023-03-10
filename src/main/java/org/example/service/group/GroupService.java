package org.example.service.group;

import org.example.dto.requestDto.GroupRequestDto;
import org.example.dto.responseDto.GroupResponseDto;
import org.example.model.group.GroupEntity;
import org.example.service.BaseService;

public interface GroupService extends BaseService<GroupRequestDto, GroupResponseDto, GroupEntity> {
}
