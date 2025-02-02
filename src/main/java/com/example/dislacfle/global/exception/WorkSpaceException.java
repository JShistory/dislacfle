package com.example.dislacfle.global.exception;

import com.example.dislacfle.global.common.BusinessException;
import com.example.dislacfle.global.common.ErrorCode;

public class WorkSpaceException extends BusinessException {
    public WorkSpaceException(ErrorCode errorCode) {
        super(errorCode);
    }

    public WorkSpaceException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
