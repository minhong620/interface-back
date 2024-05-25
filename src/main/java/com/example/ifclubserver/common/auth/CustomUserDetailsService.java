package com.example.ifclubserver.common.auth;

import static com.example.ifclubserver.member.exception.MemberErrorType.MEMBER_NOT_FOUND;

import com.example.ifclubserver.member.domain.entity.Member;
import com.example.ifclubserver.member.domain.repository.MemberRepository;
import com.example.ifclubserver.member.exception.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private final MemberRepository memberRepository;

  @Override
  public CustomUserDetails loadUserByUsername(String username){
  Member member = memberRepository.findById(Long.parseLong(username))
      .orElseThrow(() -> new MemberException(MEMBER_NOT_FOUND));
  return CustomUserDetails.builder()
      .member(member)
      .build();
  }
}
