package com.example.ifclubserver.club.domain.dto.request;

import lombok.Builder;

public record UpdateClubRequest(String name, String content, String image_url, String leader) {

    @Builder
    public static UpdateClubRequest createClubRequest(String name, String content, String image_url, String leader) {
        return new UpdateClubRequest(name, content, image_url, leader);
    }
}
