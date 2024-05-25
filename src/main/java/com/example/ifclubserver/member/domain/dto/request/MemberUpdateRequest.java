package com.example.ifclubserver.member.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberUpdateRequest {
    private String name;
    private String studentId;
    private String phone;
    private String email;
public record MemberUpdateRequest(String name, String studentId, String phone, String email) {
}
