package com.example.dislacfle.domain.user.entity.dto;

import com.example.dislacfle.domain.user.entity.UserRole;
import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String password;
    private String nickname;
    private UserRole userRole;
}
