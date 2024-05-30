package com.example.ifclubserver.notice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum NoticeErrorType {
    NOTICE_NOT_FOUND(HttpStatus.NOT_FOUND, "공지사항을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;

    NoticeErrorType(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
