package com.example.ifclubserver.member.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberUpdateForm {
    private String name;
    private String phone;
    private String email;
}
