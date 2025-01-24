package com.example.dislacfle.domain.user.service;

import com.example.dislacfle.domain.user.entity.User;
import com.example.dislacfle.domain.user.entity.dto.UserDTO;
import com.example.dislacfle.domain.user.repository.UserRepository;
import com.example.dislacfle.global.common.ErrorCode;
import com.example.dislacfle.global.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public Long joinUser(UserDTO userDTO) {
        Optional<User> findUser = userRepository.findByUsername(userDTO.getUsername());
        if (findUser.isPresent()) {
            throw new UserException(ErrorCode.DUPLICATE_USER);
        }
        User user = User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .nickname(userDTO.getNickname())
                .userRole(userDTO.getUserRole())
                .build();

        userRepository.save(user);
        return user.getId();
    }
    @Transactional
    public void deleteUser(Long id) {
        Optional<User> findUser = userRepository.findById(id);
        if (findUser.isEmpty()) {
            throw new UserException(ErrorCode.USER_NOT_FOUND);
        }
        userRepository.delete(findUser.get());
    }

}
