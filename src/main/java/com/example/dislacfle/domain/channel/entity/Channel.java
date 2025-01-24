package com.example.dislacfle.domain.channel.entity;

import com.example.dislacfle.global.common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Channel extends BaseEntity {
    private String channelName;
}
