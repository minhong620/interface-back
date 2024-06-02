package com.example.ifclubserver.post.domain.dto.response;

import java.time.LocalDateTime;

public record PostDto(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt
) {
}
