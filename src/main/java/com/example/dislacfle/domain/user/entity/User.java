package com.example.dislacfle.domain.user.entity;

import com.example.dislacfle.domain.userWorkSpace.entity.UserWorkSpace;
import com.example.dislacfle.global.common.BaseEntity;
import com.example.dislacfle.global.common.ErrorCode;
import com.example.dislacfle.global.exception.UserException;
import jakarta.persistence.*;
import java.util.ArrayList;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseEntity {
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "nickname")
    private String nickname;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @OneToMany(mappedBy = "user")
    private List<UserWorkSpace> workSpaces = new ArrayList<>();

    @Builder
    private User(String username, String password, String nickname, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.userRole = userRole;
    }

    public void changPassword(String password) {
        if (Objects.equals(this.password, password)) {
            throw new UserException(ErrorCode.DUPLICATE_PASSWORD);
        }
        this.password = password;
    }

    public void changNickname(String nickname) {
        if (Objects.equals(this.nickname, nickname)) {
            throw new UserException(ErrorCode.DUPLICATE_NICKNAME);
        }
        this.nickname = nickname;
    }

    public void addWorkSpaces(UserWorkSpace userWorkSpace) {
        this.workSpaces.add(userWorkSpace);
        userWorkSpace.setUser(this);
    }
}
