package com.example.dislacfle.global.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@AllArgsConstructor
public enum ErrorCode {

    // User errors
    DUPLICATE_USER(400, "U001", "이미 존재하는 사용자입니다."),
    INVALID_CREDENTIALS(401, "U002", "잘못된 사용자 인증 정보입니다."),
    PASSWORD_MISMATCH(400, "U003", "비밀번호가 일치하지 않습니다."),
    ACCOUNT_LOCKED(403, "U004", "계정이 잠겼습니다."),
    USER_NOT_FOUND(404, "U005", "사용자를 찾을 수 없습니다."),
    DUPLICATE_PASSWORD(400, "U006", "기존 비밀번호와 새 비밀번호가 동일합니다."),
    DUPLICATE_NICKNAME(400, "U007", "기존 닉네임과 새 닉네임이 동일합니다."),

    // Channel errors
    DUPLICATE_CHANNEL_NAME(400, "C001", "이미 존재하는 채널명입니다."),
    CHANNEL_NOT_FOUND(404, "C002", "채널을 찾을 수 없습니다."),

    // WorkSpace
    WORKSPACE_NOT_FOUND(404, "W001", "워크스페이스를 찾을 수 없습니다.");

    private final int status;
    private final String code;
    private final String message;
}

