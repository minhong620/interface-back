package com.example.ifclubserver.post.domain.dto.response;

import com.example.ifclubserver.post.domain.entity.Post;

import java.time.LocalDateTime;

public record PostDto(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static PostDto of(Post post) {
        return new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt(), post.getUpdatedAt());
    }
}
