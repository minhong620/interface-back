package com.example.ifclubserver.member.application.impl;

import com.example.ifclubserver.member.application.MemberService;
import com.example.ifclubserver.member.domain.dto.MemberDto;
import com.example.ifclubserver.member.domain.dto.request.CreateMemberRequest;
import com.example.ifclubserver.member.domain.dto.request.MemberUpdateRequest;
import com.example.ifclubserver.member.domain.dto.response.CreateMemberResponse;
import com.example.ifclubserver.member.domain.entity.Member;
import com.example.ifclubserver.member.domain.entity.constants.MemberStatus;
import com.example.ifclubserver.member.domain.repository.MemberRepository;
import com.example.ifclubserver.member.exception.MemberErrorType;
import com.example.ifclubserver.member.exception.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public CreateMemberResponse createMember(CreateMemberRequest form) {
        // MemberCreateRequest 값 검증
        // TODO: 안함

        // 요청 Form -> Member 객체 생성
        Member createdMember = Member.builder()
            .name(form.getName())
            .studentId(form.getStudentId())
            .phone(form.getPhone())
            .email(form.getEmail())
            .memberStatus(MemberStatus.ACTIVE)
            .role("USER")
            .build();

        // 생성한 Member DB 저장
        return CreateMemberResponse.from(memberRepository.save(createdMember));
    }

    @Override
    public MemberDto getMember(Long id) {
        // DB에서 Member 가져오기
        Member member = memberRepository.findById(id)
            .orElseThrow(() -> new MemberException(MemberErrorType.MEMBER_NOT_FOUND));

        // Optional인 Member를 Member로 바꾸는거
        return MemberDto.from(member);
    }

    @Override
    public List<MemberDto> getMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
            .map(MemberDto::from)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional
    @Override
    public MemberDto updateMember(Long id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        member.updateName(request.getName());
        member.updateStudentId(request.getStudentId());
        member.updatePhone(request.getPhone());
        member.updateEmail(request.getEmail());

        return MemberDto.from(memberRepository.save(member));
    }
}
