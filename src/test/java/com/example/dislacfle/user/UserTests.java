package com.example.dislacfle.user;

import com.example.dislacfle.domain.user.entity.User;
import com.example.dislacfle.domain.user.entity.UserRole;
import com.example.dislacfle.global.exception.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTests {
    @Test
    public void 중복_닉네임_예외() throws Exception {
        String currentNickname = "test123";
        User user = User.builder()
                .username("test")
                .password("test")
                .nickname(currentNickname)
                .userRole(UserRole.USER)
                .build();

        Assertions.assertThrows(UserException.class, () -> {
            user.changNickname(currentNickname);
        });
    }

    @Test
    public void 중복_패스워드_예외() throws Exception {
        String currentPassword = "test123";
        User user = User.builder()
                .username("test")
                .password(currentPassword)
                .nickname("test")
                .userRole(UserRole.USER)
                .build();

        Assertions.assertThrows(UserException.class, () -> {
            user.changPassword(currentPassword);
        });
    }
}
