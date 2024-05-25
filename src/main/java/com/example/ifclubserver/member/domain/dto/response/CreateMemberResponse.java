package com.example.ifclubserver.member.domain.dto.response;

import com.example.ifclubserver.member.domain.entity.Member;
import lombok.Builder;

public record CreateMemberResponse(Long id, String name, String studentId, String phone, String email) {

    @Builder
    public static CreateMemberResponse createMemberResponse(Long id, String name, String studentId, String phone, String email) {
        return new CreateMemberResponse(id, name, studentId, phone, email);
    }

    public static CreateMemberResponse from(Member member) {
        return CreateMemberResponse.builder()
            .id(member.getId())
            .name(member.getName())
            .studentId(member.getStudentId())
            .phone(member.getPhone())
            .email(member.getEmail())
            .build();
    }
}
