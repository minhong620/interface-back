package com.example.ifclubserver.member.domain.dto;

import com.example.ifclubserver.member.domain.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseForm {
    private final String name;
    private final String phone;
    private final String email;

    public MemberResponseForm(Member member) {
        this.name = member.getName();
        this.phone = member.getPhone();
        this.email = member.getEmail();
    }
}
