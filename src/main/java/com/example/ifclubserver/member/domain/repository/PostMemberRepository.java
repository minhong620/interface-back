package com.example.ifclubserver.member.domain.repository;

import com.example.ifclubserver.member.domain.entity.PostMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMemberRepository extends JpaRepository<PostMember,Long> {
}
