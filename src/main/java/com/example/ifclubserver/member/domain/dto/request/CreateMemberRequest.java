package com.example.ifclubserver.member.domain.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateMemberRequest {
    private String name;
    private String phone;
    private String email;

}
