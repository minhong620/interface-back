package com.example.ifclubserver.post.domain.dto.response;

import com.example.ifclubserver.post.domain.entity.Post;

public record CreatePostResponse(
        Long id
) {
    public static CreatePostResponse of(Post post) {
        return new CreatePostResponse(post.getId());
    }
}
