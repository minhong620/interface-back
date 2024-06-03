package com.example.ifclubserver.club.domain.dto.response;

import com.example.ifclubserver.club.domain.entity.Club;
import lombok.Builder;

public record CreateClubResponse(Long id, String name, String content, String image_url, String leader) {

    @Builder
    public static CreateClubResponse createClubResponse(Long id, String name, String content, String image_url, String leader){
        return new CreateClubResponse(id, name, content, image_url, leader);
    }

    public static CreateClubResponse from(Club club){
        return CreateClubResponse.builder()
                .id(club.getId())
                .name(club.getName())
                .content(club.getContent())
                .image_url(club.getImage_url())
                .leader(club.getLeader())
                .build();
    }
}
