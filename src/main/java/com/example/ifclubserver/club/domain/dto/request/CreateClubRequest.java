package com.example.ifclubserver.club.domain.dto.request;

import com.example.ifclubserver.club.domain.entity.Club;
import lombok.Builder;

public record CreateClubRequest(String name, String content, String image_url, String leader) {

    @Builder
    public static CreateClubRequest createClubRequest(String name, String content, String image_url, String leader){
        return new CreateClubRequest(name,content,image_url,leader);
    }

    public Club toEntity(){
        return Club.builder()
                .name(this.name)
                .content(this.content)
                .image_url(this.image_url)
                .leader(this.leader)
                .build();
    }
}
