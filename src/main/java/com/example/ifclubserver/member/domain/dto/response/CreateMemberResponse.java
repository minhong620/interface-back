package com.example.ifclubserver.member.domain.dto.response;

import com.example.ifclubserver.member.domain.entity.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class CreateMemberResponse {
    private Long memberId;
    private String name;
    private String email;

    public static CreateMemberResponse from(Member member) {
        return CreateMemberResponse.builder()
                .memberId(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }

}
