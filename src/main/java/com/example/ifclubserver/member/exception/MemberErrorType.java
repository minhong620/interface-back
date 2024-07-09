package com.example.ifclubserver.member.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MemberErrorType {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않습니다."),
    EMAIL_ALREADY_EXIST(HttpStatus.CONFLICT, "이메일이 이미 존재합니다."),
    EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "이메일이 존재하지 않습니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.")
    ;

    private final HttpStatus status;
    private final String message;


    MemberErrorType(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
