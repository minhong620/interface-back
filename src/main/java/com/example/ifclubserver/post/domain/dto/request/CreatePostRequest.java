package com.example.ifclubserver.post.domain.dto.request;

import com.example.ifclubserver.post.domain.entity.Post;

import java.time.LocalDateTime;

public record CreatePostRequest(
        String title,
        String content
) {
    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
