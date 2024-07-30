package com.example.ifclubserver.post.domain.entity;

import com.example.ifclubserver.club.domain.entity.Club;
import com.example.ifclubserver.common.entitiy.BaseEntity;
import com.example.ifclubserver.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @Builder
    public Post(String title, String content, Member member, Club club) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.club = club;
    }

    public void updatePost(String title, String content) {
        if (title.isBlank() && content.isBlank()) return;
        if (!title.isBlank()) this.title = title;
        if (!content.isBlank()) this.content = content;
    }
}
