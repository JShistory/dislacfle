package com.example.dislacfle.global.exception;

import com.example.dislacfle.global.common.BusinessException;
import com.example.dislacfle.global.common.ErrorCode;

public class ChannelException extends BusinessException {
    public ChannelException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ChannelException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
