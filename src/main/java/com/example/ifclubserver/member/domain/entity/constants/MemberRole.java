package com.example.ifclubserver.member.domain.entity.constants;

import lombok.Getter;

@Getter
public enum MemberRole {
  USER("ROLE_USER"),
  ADMIN("ROLE_ADMIN");

  private final String description;

  MemberRole(String description) {
    this.description = description;
  }

}
