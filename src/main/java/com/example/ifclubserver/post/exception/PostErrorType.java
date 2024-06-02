package com.example.ifclubserver.post.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum PostErrorType {
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다."),
    ;

    private final HttpStatus status;
    private final String message;

    PostErrorType(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
