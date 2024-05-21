package com.example.ifclubserver.member.domain.entity.constants;

public enum MemberStatus {

  ACTIVE("활성화"),
  DEACTIVE("비활성화");

  private final String description;

  MemberStatus(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
