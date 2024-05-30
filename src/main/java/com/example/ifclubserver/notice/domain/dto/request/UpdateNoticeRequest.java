package com.example.ifclubserver.notice.domain.dto.request;

import lombok.Builder;

public record UpdateNoticeRequest(String title, String content) {

    @Builder
    public static UpdateNoticeRequest createUpdateNoticeRequest(String title, String content) {
        return new UpdateNoticeRequest(title, content);
    }
}
