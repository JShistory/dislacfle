package com.example.dislacfle.domain.workSpace.entity;

import com.example.dislacfle.domain.channel.entity.Channel;
import com.example.dislacfle.domain.user.entity.User;
import com.example.dislacfle.domain.userWorkSpace.entity.UserWorkSpace;
import com.example.dislacfle.global.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class WorkSpace extends BaseEntity {
    @Column(name = "spaceName", unique = true, nullable = false)
    private String spaceName;
    @OneToMany
    private List<UserWorkSpace> users = new ArrayList<>();
    @OneToMany
    private List<Channel> channels = new ArrayList<>();
    @Builder
    private WorkSpace(String spaceName, List<UserWorkSpace> users, List<Channel> channels) {
        this.spaceName = spaceName;
        this.users = users;
        this.channels = channels;
    }
}
