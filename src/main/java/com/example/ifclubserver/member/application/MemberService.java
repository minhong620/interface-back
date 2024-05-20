package com.example.ifclubserver.member.application;

import com.example.ifclubserver.member.domain.dto.MemberDto;
import com.example.ifclubserver.member.domain.dto.request.CreateMemberRequest;
import com.example.ifclubserver.member.domain.dto.request.MemberUpdateRequest;
import com.example.ifclubserver.member.domain.dto.response.CreateMemberResponse;
import com.example.ifclubserver.member.domain.entity.Member;

public interface MemberService {

    // 멤버 생성
    public CreateMemberResponse createMember(CreateMemberRequest form);

    // 멤버 가져오기
    public MemberDto getMember(Long id);

    public void deleteMember(Long id);

    public MemberDto updateMember(Long id, MemberUpdateRequest request);
}
