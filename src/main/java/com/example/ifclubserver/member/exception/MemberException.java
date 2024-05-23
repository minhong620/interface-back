package com.example.ifclubserver.member.exception;

import lombok.Getter;

@Getter
public class MemberException extends RuntimeException {
    private final MemberErrorType errorType;

    public MemberException(MemberErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public MemberException(MemberErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }
}
