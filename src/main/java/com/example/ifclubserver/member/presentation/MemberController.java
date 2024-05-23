package com.example.ifclubserver.member.presentation;

import com.example.ifclubserver.member.application.impl.MemberServiceImpl;
import com.example.ifclubserver.member.domain.dto.MemberDto;
import com.example.ifclubserver.member.domain.dto.request.CreateMemberRequest;
import com.example.ifclubserver.member.domain.dto.request.MemberUpdateRequest;
import com.example.ifclubserver.member.domain.dto.response.CreateMemberResponse;
import com.example.ifclubserver.member.domain.entity.Member;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    final private MemberServiceImpl memberServiceImpl;


    @PostMapping("/members")
    public ResponseEntity<CreateMemberResponse> create(CreateMemberRequest form, HttpServletResponse httpServletResponse) {
        // CORS 허용 헤더 추가
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://220.85.169.165:3002");
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS");
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type, Authorization");
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");

        // 멤버 저장 로직 호출
        CreateMemberResponse createMemberResponse = memberServiceImpl.createMember(form);

        return ResponseEntity.ok(createMemberResponse);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberDto> getMember(
            @PathVariable("id") Long id , HttpServletResponse httpServletResponse
    ) {
        // CORS 허용 헤더 추가
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://220.85.169.165:3002");
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS");
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type, Authorization");
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        MemberDto memberDto = memberServiceImpl.getMember(id);

        return ResponseEntity.ok(memberDto);
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable long id, HttpServletResponse httpServletResponse) {
        // CORS 허용 헤더 추가
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://220.85.169.165:3002");
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS");
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type, Authorization");
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        memberServiceImpl.deleteMember(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<MemberDto> updateMember(@PathVariable long id, @RequestBody MemberUpdateRequest memberUpdate, HttpServletResponse httpServletResponse) {
        // CORS 허용 헤더 추가
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://220.85.169.165:3002");
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS");
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type, Authorization");
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");

        return ResponseEntity.ok()
                .body(memberServiceImpl.updateMember(id, memberUpdate));
    }
}