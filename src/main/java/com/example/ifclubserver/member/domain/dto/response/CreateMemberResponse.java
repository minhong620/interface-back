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

    public static CreateMemberResponse from(Member member) {
        return CreateMemberResponse.builder()
            .memberId(member.getId())
            .name(member.getName())
            .studentId(member.getStudentId())
            .email(member.getEmail())
            .build();
    }
}
