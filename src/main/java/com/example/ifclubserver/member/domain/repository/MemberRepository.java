package com.example.ifclubserver.member.domain.repository;

import com.example.ifclubserver.member.domain.entity.Member;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  Optional<Member> findById(Long id);
  Optional<Member> findByStudentId(String studentId);
  Optional<Member> findByEmail(String email);

  Slice<Member> findById(Long id, PageRequest pageRequest);
}
