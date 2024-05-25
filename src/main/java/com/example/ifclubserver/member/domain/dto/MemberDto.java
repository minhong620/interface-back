package com.example.ifclubserver.member.domain.dto;

import com.example.ifclubserver.member.domain.entity.Member;
import lombok.Builder;

@Builder
public record MemberDto(Long id, String name, String phone, String email) {

    public static MemberDto from(Member member) {
        return new MemberDto(
                member.getId(),
                member.getName(),
                member.getPhone(),
                member.getEmail()
        );
    }
}
