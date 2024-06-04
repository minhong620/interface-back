package com.example.ifclubserver.post.exception;

import lombok.Getter;

@Getter
public class PostException extends RuntimeException{

    private final PostErrorType errorType;

    public PostException(PostErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public PostException(PostErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

}
