package com.example.dislacfle.domain.channel.entity;

import com.example.dislacfle.domain.workSpace.entity.WorkSpace;
import com.example.dislacfle.global.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Channel extends BaseEntity {
    @Column(name = "uuid", unique = true, nullable = false)
    private String uuid;
    @Column(name = "channelName", nullable = false)
    private String channelName;
    @ManyToOne
    private WorkSpace workSpace;

    @Builder
    private Channel(String uuid, String channelName, WorkSpace workSpace) {
        this.uuid = uuid;
        this.channelName = channelName;
        this.workSpace = workSpace;
    }

    public void setWorkSpace(WorkSpace workSpace) {
        this.workSpace = workSpace;
    }

    public static Channel createDefaultChannel(WorkSpace workSpace) {
        return Channel.builder()
                .uuid(UUID.randomUUID().toString())
                .channelName("Default Channel")
                .workSpace(workSpace)
                .build();
    }
}
