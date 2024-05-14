package com.example.ifclubserver.member.presentation;

import com.example.ifclubserver.member.application.impl.MemberServiceImpl;
import com.example.ifclubserver.member.domain.dto.MemberDto;
import com.example.ifclubserver.member.domain.dto.request.CreateMemberRequest;
import com.example.ifclubserver.member.domain.dto.request.MemberUpdateRequest;
import com.example.ifclubserver.member.domain.dto.response.CreateMemberResponse;
import com.example.ifclubserver.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    final private MemberServiceImpl memberServiceImpl;


    @PostMapping("/members")
    public ResponseEntity<CreateMemberResponse> create(CreateMemberRequest form) {

        // 멤버 저장 로직 호출
        CreateMemberResponse createMemberResponse = memberServiceImpl.createMember(form);

        return ResponseEntity.ok(createMemberResponse);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberDto> getMember(
            @PathVariable("id") Long id
    ) {
        MemberDto memberDto = memberServiceImpl.getMember(id);

        return ResponseEntity.ok(memberDto);
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable long id) {
        memberServiceImpl.deleteMember(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<MemberDto> updateMember(@PathVariable long id, @RequestBody MemberUpdateRequest memberUpdate) {

        return ResponseEntity.ok()
                .body(memberServiceImpl.updateMember(id, memberUpdate));
    }
}