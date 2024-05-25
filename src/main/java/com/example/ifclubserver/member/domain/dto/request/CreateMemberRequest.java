package com.example.ifclubserver.member.domain.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateMemberRequest {
    private String name;
    private String studentId;
    private String phone;
    private String email;

public record CreateMemberRequest(String name, String String studentId, phone,String email) {
}
