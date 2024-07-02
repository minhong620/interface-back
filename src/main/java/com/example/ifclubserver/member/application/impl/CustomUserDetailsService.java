package com.example.ifclubserver.member.application.impl;

import com.example.ifclubserver.member.domain.entity.CustomUserDetails;
import com.example.ifclubserver.member.domain.entity.Member;
import com.example.ifclubserver.member.domain.repository.MemberRepository;
import com.example.ifclubserver.member.exception.MemberErrorType;
import com.example.ifclubserver.member.exception.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private final MemberRepository memberRepository;


  @Override
  public CustomUserDetails loadUserByUsername(String stringMemberId)
      throws UsernameNotFoundException {
    Member member = memberRepository.findById(Long.parseLong(stringMemberId))
        .orElseThrow(
            () -> new MemberException(MemberErrorType.MEMBER_NOT_FOUND));
    return new CustomUserDetails(member);
  }
}
