package com.example.ifclubserver.post.domain.repository;

import com.example.ifclubserver.post.domain.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Slice<Post> findByClubId(Long clubId, Pageable pageable);
}
