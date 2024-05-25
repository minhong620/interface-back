package com.example.ifclubserver.member.domain.dto;

import com.example.ifclubserver.member.domain.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberDto {
    private long id;
    private String name;
    private String studentId;
    private String phone;
    private String email;

    public static MemberDto from(Member member) {
        return MemberDto.builder()
            .id(member.getId())
            .name(member.getName())
            .studentId(member.getStudentId())
            .phone(member.getPhone())
            .email(member.getEmail())
            .build();
    }
}
