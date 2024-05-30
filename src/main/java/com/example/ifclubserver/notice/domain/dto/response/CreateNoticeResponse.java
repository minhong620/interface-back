package com.example.ifclubserver.notice.domain.dto.response;

import com.example.ifclubserver.notice.domain.entity.Notice;
import lombok.Builder;

public record CreateNoticeResponse(Long id, String title, String content, String author, String createdAt, String updatedAt) {

    @Builder
    public static CreateNoticeResponse createNoticeResponse(Long id, String title, String content, String author, String createdAt, String updatedAt) {
        return new CreateNoticeResponse(id, title, content, author, createdAt, updatedAt);
    }

    public static CreateNoticeResponse from(Notice notice) {
        return CreateNoticeResponse.builder()
            .id(notice.getId())
            .title(notice.getTitle())
            .content(notice.getContent())
            .author(notice.getAuthor())
            .createdAt(notice.getCreatedAt())
            .updatedAt(notice.getUpdatedAt())
            .build();
    }
}
