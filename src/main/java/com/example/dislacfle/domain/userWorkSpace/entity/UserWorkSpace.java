package com.example.dislacfle.domain.userWorkSpace.entity;

import com.example.dislacfle.domain.user.entity.User;
import com.example.dislacfle.domain.workSpace.entity.WorkSpace;
import com.example.dislacfle.global.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class UserWorkSpace extends BaseEntity {
    @ManyToOne
    private User user;
    @ManyToOne
    private WorkSpace workSpace;

    @Builder
    public UserWorkSpace(User user, WorkSpace workSpace) {
        this.user = user;
        this.workSpace = workSpace;
    }

    public UserWorkSpace() {

    }

    public static UserWorkSpace createUserWorkSpace(User user, WorkSpace workSpace) {
        return UserWorkSpace.builder()
                .user(user)
                .workSpace(workSpace)
                .build();
    }
}
