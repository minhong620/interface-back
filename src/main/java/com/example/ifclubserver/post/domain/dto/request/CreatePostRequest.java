package com.example.ifclubserver.post.domain.dto.request;

import lombok.Getter;

import java.time.LocalDateTime;

public record CreatePostRequest(
        String title,
        String content,
        LocalDateTime createdAt
) {
}
