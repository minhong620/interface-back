package com.example.ifclubserver.notice.domain.dto;

import com.example.ifclubserver.notice.domain.entity.Notice;
import lombok.Builder;

public record NoticeDto(Long id, String title, String content, String author, String createdAt, String updatedAt) {

    @Builder
    public static NoticeDto createNoticeDto(Long id, String title, String content, String author, String createdAt, String updatedAt) {
        return new NoticeDto(id, title, content, author, createdAt, updatedAt);
    }

    public static NoticeDto from(Notice notice) {
        return NoticeDto.builder()
            .id(notice.getId())
            .title(notice.getTitle())
            .content(notice.getContent())
            .author(notice.getAuthor())
            .build();
    }
}
