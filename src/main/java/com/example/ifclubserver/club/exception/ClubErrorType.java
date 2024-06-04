package com.example.ifclubserver.club.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ClubErrorType {
    NOTICE_NOT_FOUND(HttpStatus.NOT_FOUND,"소모임을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;

    ClubErrorType(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
