package com.example.ifclubserver.member.application.impl;

import com.example.ifclubserver.member.domain.dto.MemberCreateForm;
import com.example.ifclubserver.member.domain.entity.Member;
import com.example.ifclubserver.member.domain.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  final private MemberRepository memberRepository;

  @Override
  public Member createMember(MemberCreateForm form) {
    // MemberCreateRequest 값 검증
    // TODO: 안함

    // 요청 Form -> Member 객체 생성
    Member createdMember = Member.builder()
        .name(form.getName())
        .phone(form.getPhone())
        .email(form.getEmail())
        .build();

    // 생성한 Member DB 저장
    Member savedMember = memberRepository.save(createdMember);

    return savedMember;
  }

  @Override
  public Member getMember(Long id) {
    // DB에서 Member 가져오기
//    Member member = memberRepository.findById(id)
//        .orElseThrow(() -> CustomError(ErrorCode.MEMBER_NOT_FOUND);

    // 멤버 가져오기 (Optional)
    Optional<Member> optionalMember = memberRepository.findById(id);

    // 멤버 검증 -> 문제있음 에러
    if(optionalMember.isEmpty()){
      throw new IllegalArgumentException("멤버 찾을수없음");
    }

    // Optional인 Member를 Member로 바꾸는거
    Member member = optionalMember.get();

    return member;
  }
}
