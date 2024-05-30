package com.example.ifclubserver.notice.domain.dto.request;

import com.example.ifclubserver.notice.domain.entity.Notice;
import lombok.Builder;

public record CreateNoticeRequest(String title, String content, String author) {

    @Builder
    public static CreateNoticeRequest createNoticeRequest(String title, String content, String author) {
        return new CreateNoticeRequest(title, content, author);
    }

    public Notice toEntity() {
        return Notice.builder()
            .title(this.title)
            .content(this.content)
            .author(this.author)
            .createdAt(System.currentTimeMillis() + "")
            .updatedAt(System.currentTimeMillis() + "")
            .build();
    }
}
