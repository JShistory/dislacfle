package com.example.dislacfle.domain.workSpace.service;

import com.example.dislacfle.domain.channel.entity.Channel;
import com.example.dislacfle.domain.channel.repository.ChannelRepository;
import com.example.dislacfle.domain.user.entity.User;
import com.example.dislacfle.domain.user.repository.UserRepository;
import com.example.dislacfle.domain.userWorkSpace.entity.UserWorkSpace;
import com.example.dislacfle.domain.userWorkSpace.repository.UserWorkSpaceRepository;
import com.example.dislacfle.domain.workSpace.entity.WorkSpace;
import com.example.dislacfle.domain.workSpace.entity.dto.WorkSpaceDTO;
import com.example.dislacfle.domain.workSpace.repository.WorkSpaceRepository;
import com.example.dislacfle.global.common.ErrorCode;
import com.example.dislacfle.global.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WorkSpaceService {
    private final WorkSpaceRepository workSpaceRepository;
    private final UserWorkSpaceRepository userWorkSpaceRepository;
    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long createWorkSpace(WorkSpaceDTO workSpaceDTO) {
        User user = userRepository.findById(workSpaceDTO.getUserId())
                .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));

        // 워크스페이스 초기화
        WorkSpace workSpace = WorkSpace.builder()
                .spaceName(workSpaceDTO.getWorkSpaceName())
                .build();

        // 유저-워크스페이스 관계 생성
        UserWorkSpace userWorkSpace = createUserWorkSpace(user, workSpace);
        userWorkSpaceRepository.save(userWorkSpace);

        //기본 채널 생성
        Channel defaultChannel = workSpace.createDefaultChannel();
        channelRepository.save(defaultChannel);

        // 워크스페이스 저장
        workSpaceRepository.save(workSpace);

        return workSpace.getId();
    }

    private UserWorkSpace createUserWorkSpace(User user, WorkSpace workSpace) {
        UserWorkSpace userWorkSpace = new UserWorkSpace();
        userWorkSpace.setUser(user);
        userWorkSpace.setWorkSpace(workSpace);

        workSpace.addUsers(userWorkSpace);
        user.addWorkSpaces(userWorkSpace);
        return userWorkSpace;
    }
}
