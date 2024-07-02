package com.example.ifclubserver.member.domain.dto.request;

public record LoginMemberRequest(
    String email, String password
) {
}
