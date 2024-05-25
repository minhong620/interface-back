package com.example.ifclubserver.member.domain.dto.request;

import com.example.ifclubserver.member.domain.entity.Member;
import com.example.ifclubserver.member.domain.entity.constants.MemberRole;
import com.example.ifclubserver.member.domain.entity.constants.MemberStatus;
import lombok.Builder;

public record CreateMemberRequest(String name, String studentId, String phone, String email) {

    @Builder
    public static CreateMemberRequest createMemberRequest(String name, String studentId, String phone, String email) {
        return new CreateMemberRequest(name, studentId, phone, email);
    }

    public Member toEntity() {
        return Member.builder()
            .name(this.name)
            .studentId(this.studentId)
            .phone(this.phone)
            .email(this.email)
            .status(MemberStatus.ACTIVE)
            .role(MemberRole.USER)
            .build();
    }
}
