package com.example.ifclubserver.member.domain.dto.response;

import com.example.ifclubserver.member.domain.entity.Member;
import lombok.Builder;

@Builder
public record CreateMemberResponse(Long id, String name, String phone, String email) {

    public static CreateMemberResponse from(Member member) {
        return new CreateMemberResponse(
                member.getId(),
                member.getName(),
                member.getPhone(),
                member.getEmail()
        );
    }

}
