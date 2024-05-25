package com.example.ifclubserver.member.domain.dto.response;

import com.example.ifclubserver.member.domain.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateMemberResponse {
    private Long memberId;
    private String name;
    private String studentId;
    private String email;

@Builder
public record CreateMemberResponse(Long id, String name, String phone, String email) {

    public static CreateMemberResponse from(Member member) {
        return new CreateMemberResponse(
                member.getId(),
                member.getName(),
                member.getStudentId(),
                member.getPhone(),
                member.getEmail()
        );
    }
}
