package com.example.ifclubserver.member.application;

import com.example.ifclubserver.member.domain.dto.MemberDto;
import com.example.ifclubserver.member.domain.dto.request.CreateMemberRequest;
import com.example.ifclubserver.member.domain.dto.request.UpdateMemberRequest;
import com.example.ifclubserver.member.domain.dto.response.CreateMemberResponse;
import java.util.List;

public interface MemberService {

    // 멤버 생성
    CreateMemberResponse createMember(CreateMemberRequest form);

    // 멤버 가져오기
    MemberDto getMember(Long id);

    List<MemberDto> getMembers();

    void deleteMember(Long id);

    MemberDto updateMember(Long id, UpdateMemberRequest request);
}
