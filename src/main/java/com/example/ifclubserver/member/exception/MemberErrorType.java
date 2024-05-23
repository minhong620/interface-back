package com.example.ifclubserver.member.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MemberErrorType {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않습니다.");

    private final HttpStatus status;
    private final String message;


    MemberErrorType(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
