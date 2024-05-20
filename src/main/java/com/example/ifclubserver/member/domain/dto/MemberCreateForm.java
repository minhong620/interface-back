package com.example.ifclubserver.member.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberCreateForm {
  private String name;
  private String phone;
  private String email;

}
