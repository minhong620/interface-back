package com.example.ifclubserver.member.domain.dto.request;

import lombok.Builder;

public record UpdateMemberRequest(String name, String studentId, String phone, String email) {

    @Builder
    public static UpdateMemberRequest createMemberUpdateRequest(String name, String studentId, String phone, String email) {
        return new UpdateMemberRequest(name, studentId, phone, email);
    }
}
