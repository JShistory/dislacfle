package com.example.dislacfle.domain.channel.service;

import com.example.dislacfle.domain.channel.entity.Channel;
import com.example.dislacfle.domain.channel.repository.ChannelRepository;
import com.example.dislacfle.domain.workSpace.entity.WorkSpace;
import com.example.dislacfle.domain.workSpace.entity.dto.ChannelDTO;
import com.example.dislacfle.domain.workSpace.repository.WorkSpaceRepository;
import com.example.dislacfle.global.common.ErrorCode;
import com.example.dislacfle.global.exception.WorkSpaceException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ChannelService {
    private final ChannelRepository channelRepository;
    private final WorkSpaceRepository workSpaceRepository;

    @Transactional
    public String createChannel(ChannelDTO channelDTO) {
        WorkSpace workSpace = workSpaceRepository.findById(channelDTO.getWorkSpaceId())
                .orElseThrow(() -> new WorkSpaceException(ErrorCode.WORKSPACE_NOT_FOUND));

        Channel createChannel = Channel.builder()
                .workSpace(workSpace)
                .channelName(channelDTO.getChannelName())
                .uuid(UUID.randomUUID().toString())
                .build();

        workSpace.addChannels(createChannel);

        channelRepository.save(createChannel);

        return createChannel.getUuid();
    }
}
