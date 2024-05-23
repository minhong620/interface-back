package com.example.ifclubserver.common.exception;

import com.example.ifclubserver.member.exception.MemberException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MemberException.class)
    public ResponseEntity<Object> handleCustomException(MemberException e) {
        return ResponseEntity.status(e.getErrorType().getStatus()).body(e.getErrorType().getMessage());
    }
}
