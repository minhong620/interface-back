package com.example.ifclubserver.member.application.impl;

import com.example.ifclubserver.common.jwt.JwtUtils;
import com.example.ifclubserver.member.application.MemberService;
import com.example.ifclubserver.member.domain.dto.MemberDto;
import com.example.ifclubserver.member.domain.dto.request.CreateMemberRequest;
import com.example.ifclubserver.member.domain.dto.request.LoginMemberRequest;
import com.example.ifclubserver.member.domain.dto.request.SignUpMemberRequest;
import com.example.ifclubserver.member.domain.dto.request.UpdateMemberRequest;
import com.example.ifclubserver.member.domain.dto.response.CreateMemberResponse;
import com.example.ifclubserver.member.domain.dto.response.LoginMemberResponse;
import com.example.ifclubserver.member.domain.entity.CustomUserDetails;
import com.example.ifclubserver.member.domain.entity.Member;
import com.example.ifclubserver.member.domain.entity.constants.MemberRole;
import com.example.ifclubserver.member.domain.entity.constants.MemberStatus;
import com.example.ifclubserver.member.domain.repository.MemberRepository;
import com.example.ifclubserver.member.exception.MemberErrorType;
import com.example.ifclubserver.member.exception.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final JwtUtils jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CreateMemberResponse createMember(CreateMemberRequest form) {

        Member createdMember = form.toEntity();

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
    public MemberDto updateMember(Long id, UpdateMemberRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        member.updateName(request.name());
        member.updateStudentId(request.studentId());
        member.updatePhone(request.phone());
        member.updateEmail(request.email());

        return MemberDto.from(memberRepository.save(member));
    }

    public MemberDto save(SignUpMemberRequest form) {
        // 이메일 중복 확인
        if (memberRepository.findByEmail(form.email()).isPresent()) {
            throw new MemberException(MemberErrorType.EMAIL_ALREADY_EXIST);
        }

        return MemberDto.from(
                memberRepository.save(Member.builder()
                        .name(form.name())
                        .studentId(form.studentId())
                        .password(form.password())
                        .phone(form.phone())
                        .email(form.email())
                        .status(MemberStatus.ACTIVE)
                        .role(MemberRole.USER)
                        .build()
                )
        );
    }

    public LoginMemberResponse login(LoginMemberRequest form) {
        // 아이디 검증
        Member member = memberRepository.findByEmail(form.email())
                .orElseThrow(() -> new MemberException(MemberErrorType.EMAIL_NOT_FOUND));

        // 비밀번호 검증
        if (!passwordEncoder.matches(form.password(), member.getPassword())) {
            throw new MemberException(MemberErrorType.INVALID_PASSWORD);
        }

        String accessToken = jwtUtil.createAccessToken(
                CustomUserDetails.builder()
                        .member(member)
                        .build());

        return LoginMemberResponse.from(member, accessToken);
    }
}
