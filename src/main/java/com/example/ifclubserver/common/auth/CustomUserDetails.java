package com.example.ifclubserver.common.auth;

import com.example.ifclubserver.member.domain.entity.Member;
import com.example.ifclubserver.member.domain.entity.constants.MemberStatus;
import java.util.Collection;
import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@AllArgsConstructor
@Builder
public class CustomUserDetails implements UserDetails {
  private final Member member;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(
        new SimpleGrantedAuthority(member.getRole().getDescription()));
  }

  @Override
  public String getPassword() {
    return member.getPassword();
  }

  // Username 은 MemberId로 가정한다.
  @Override
  public String getUsername() {
    return member.getId().toString();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return member.getStatus() == MemberStatus.ACTIVE;
  }
}
