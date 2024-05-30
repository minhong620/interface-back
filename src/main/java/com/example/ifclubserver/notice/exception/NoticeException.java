package com.example.ifclubserver.notice.exception;

import lombok.Getter;

@Getter
public class NoticeException extends RuntimeException {
    private final NoticeErrorType errorType;

    public NoticeException(NoticeErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public NoticeException(NoticeErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }
}
