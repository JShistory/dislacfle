package com.example.dislacfle.global.common;

import com.example.dislacfle.global.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ApiResponse<?>> handleUserException(UserException e) {
        ErrorCode errorCode = e.getErrorCode();
        ApiResponse<?> response = ApiResponse.builder()
                .success(false)
                .message(errorCode.getMessage())
                .data(null)
                .build();

        return ResponseEntity
                .status(HttpStatus.valueOf(errorCode.getStatus()))
                .body(response);
    }

}
