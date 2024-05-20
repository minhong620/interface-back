package com.example.ifclubserver.member.application.impl;

import com.example.ifclubserver.member.domain.dto.MemberCreateForm;
import com.example.ifclubserver.member.domain.entity.Member;

public interface MemberService {

  // 멤버 생성
  public Member createMember(MemberCreateForm form);

  // 멤버 가져오기
  Member getMember(Long id);
}
