package com.example.ifclubserver.member.application.impl;

import com.example.ifclubserver.member.application.MemberService;
import com.example.ifclubserver.member.domain.dto.MemberDto;
import com.example.ifclubserver.member.domain.dto.request.CreateMemberRequest;
import com.example.ifclubserver.member.domain.dto.request.MemberUpdateRequest;
import com.example.ifclubserver.member.domain.dto.response.CreateMemberResponse;
import com.example.ifclubserver.member.domain.entity.Member;
import com.example.ifclubserver.member.domain.repository.MemberRepository;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    final private MemberRepository memberRepository;

    @Override
    public CreateMemberResponse createMember(CreateMemberRequest form) {
        // MemberCreateRequest 값 검증
        // TODO: 안함

        // 요청 Form -> Member 객체 생성
        Member createdMember = Member.builder()
                .name(form.getName())
                .phone(form.getPhone())
                .email(form.getEmail())
                .build();

        // 생성한 Member DB 저장
        return CreateMemberResponse.from(memberRepository.save(createdMember));
    }

    @Override
    public MemberDto getMember(Long id) {
        // DB에서 Member 가져오기
//    Member member = memberRepository.findById(id)
//        .orElseThrow(() -> CustomError(ErrorCode.MEMBER_NOT_FOUND);

        // 멤버 가져오기 (Optional)
        Optional<Member> optionalMember = memberRepository.findById(id);

        // 멤버 검증 -> 문제있음 에러
        if (optionalMember.isEmpty()) {
            throw new IllegalArgumentException("멤버 찾을수없음");
        }

        // Optional인 Member를 Member로 바꾸는거
        return MemberDto.from(optionalMember.get());
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional
    public MemberDto updateMember(Long id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        member.updateName(request.getName());
        member.updatePhone(request.getPhone());
        member.updateEmail(request.getEmail());

        return MemberDto.from(memberRepository.save(member));
    }
}
