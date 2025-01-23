package com.example.dislacfle.domain.user.controller;

import com.example.dislacfle.domain.user.entity.dto.UserDTO;
import com.example.dislacfle.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> joinUser(@RequestBody UserDTO userDTO) {
        Long joinedUserId = userService.joinUser(userDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User created with Id : " + joinedUserId);
    }

}
