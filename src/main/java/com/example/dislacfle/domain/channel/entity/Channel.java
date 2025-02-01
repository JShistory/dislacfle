package com.example.dislacfle.domain.channel.entity;

import com.example.dislacfle.domain.workSpace.entity.WorkSpace;
import com.example.dislacfle.global.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Channel extends BaseEntity {
    private String channelName;
    @ManyToOne
    private WorkSpace workSpace;

    @Builder
    private Channel(String channelName, WorkSpace workSpace) {
        this.channelName = channelName;
        this.workSpace = workSpace;
    }

    public void setWorkSpace(WorkSpace workSpace) {
        this.workSpace = workSpace;
    }
}
