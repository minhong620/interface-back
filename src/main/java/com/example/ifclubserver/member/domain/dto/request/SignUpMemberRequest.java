package com.example.ifclubserver.member.domain.dto.request;

public record SignUpMemberRequest(
        String name,
        String studentId,
        String password,
        String phone,
        String email
) {
}
