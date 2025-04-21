package com.example.dislacfle.domain.workSpace.entity;

import com.example.dislacfle.domain.channel.entity.Channel;
import com.example.dislacfle.domain.user.entity.User;
import com.example.dislacfle.domain.userWorkSpace.entity.UserWorkSpace;
import com.example.dislacfle.global.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class WorkSpace extends BaseEntity {
    @Column(name = "spaceName", unique = true, nullable = false)
    private String spaceName;
    @OneToMany(mappedBy = "workSpace")
    private List<UserWorkSpace> users = new ArrayList<>();
    @OneToMany(mappedBy = "workSpace")
    private List<Channel> channels = new ArrayList<>();
    @Builder
    private WorkSpace(String spaceName) {
        this.spaceName = spaceName;
    }

    public void addUsers(UserWorkSpace userWorkSpace) {
        this.users.add(userWorkSpace);
        userWorkSpace.setWorkSpace(this);
    }

    public void addChannels(Channel channel) {
        this.channels.add(channel);
        channel.setWorkSpace(this);
    }
}
