package com.example.dislacfle.global.exception;

import com.example.dislacfle.global.common.BusinessException;
import com.example.dislacfle.global.common.ErrorCode;

public class UserException extends BusinessException {
    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }

    public UserException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
