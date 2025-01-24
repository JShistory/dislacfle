package com.example.dislacfle.domain.userWorkSpace.entity;

import com.example.dislacfle.domain.user.entity.User;
import com.example.dislacfle.domain.workSpace.entity.WorkSpace;
import com.example.dislacfle.global.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class UserWorkSpace extends BaseEntity {
    @ManyToOne
    private User user;
    @ManyToOne
    private WorkSpace workSpace;
}
