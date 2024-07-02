package com.example.ifclubserver.member.domain.dto.request;

import java.time.LocalDate;

public record SignUpMemberRequest(
    String name, String studentId, String password, String phone, String email
) {
}
