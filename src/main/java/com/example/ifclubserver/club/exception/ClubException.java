package com.example.ifclubserver.club.exception;

import lombok.Getter;

@Getter
public class ClubException extends RuntimeException{
    private final ClubErrorType errorType;

    public ClubException(ClubErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

    public ClubException(ClubErrorType errorType, String message){
        super(message);
        this.errorType=errorType;
    }
}
