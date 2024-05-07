package com.example.ifclubserver.member.presentation;

import com.example.ifclubserver.member.application.impl.MemberServiceImpl;
import com.example.ifclubserver.member.domain.dto.MemberCreateForm;
import com.example.ifclubserver.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

  final private MemberServiceImpl memberServiceImpl;


  @PostMapping("/members")
  public ResponseEntity<Member> create(MemberCreateForm form) {

    // 멤버 저장 로직 호출
    Member savedMember = memberServiceImpl.createMember(form);

    return ResponseEntity.ok(savedMember);
  }

  @GetMapping("/members/{id}")
  public ResponseEntity<Member> getMember(
      @PathVariable("id") Long id
  ) {
    Member member = memberServiceImpl.getMember(id);

    return ResponseEntity.ok(member);
  }
}