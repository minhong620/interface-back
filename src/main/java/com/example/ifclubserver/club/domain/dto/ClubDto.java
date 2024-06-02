package com.example.ifclubserver.club.domain.dto;

import com.example.ifclubserver.club.domain.entity.Club;
import lombok.Builder;

public record ClubDto (Long id, String name, String content, String image_url, String leader){

    @Builder
    public static ClubDto createClubDto(Long id, String name, String content, String image_url, String leader){
        return new ClubDto(id, name, content, image_url, leader);
    }

    public static ClubDto from(Club club){
        return ClubDto.builder()
                .id(club.getId())
                .name(club.getName())
                .content(club.getContent())
                .image_url(club.getImage_url())
                .leader(club.getLeader())
                .build();
    }
}
