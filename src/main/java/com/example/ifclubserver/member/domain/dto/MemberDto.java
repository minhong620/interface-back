package com.example.ifclubserver.member.domain.dto;

import com.example.ifclubserver.member.domain.entity.Member;
import lombok.Builder;

public record MemberDto(long id, String name, String studentId, String phone, String email) {

    @Builder
    public static MemberDto createMemberDto(long id, String name, String studentId, String phone, String email) {
        return new MemberDto(id, name, studentId, phone, email);
    }

    public static MemberDto from(Member member) {
        return MemberDto.builder()
            .id(member.getId())
            .name(member.getName())
            .studentId(member.getStudentId())
            .phone(member.getPhone())
            .email(member.getEmail())
            .build();
    }
}
