package com.example.ifclubserver.post.domain.repository;

import com.example.ifclubserver.post.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
