package com.example.ifclubserver.member.domain.dto.response;

import com.example.ifclubserver.member.domain.dto.MemberDto;
import com.example.ifclubserver.member.domain.entity.Member;

public record LoginMemberResponse(
        MemberDto memberDto,
        String accessToken
) {
    public static LoginMemberResponse from(Member member, String accessToken) {
        return new LoginMemberResponse(MemberDto.from(member), accessToken);
    }
}
