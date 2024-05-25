package com.example.ifclubserver.member.domain.dto.request;

import lombok.Builder;

@Builder
public record CreateMemberRequest(String name, String phone,String email) {

}
