package com.example.ifclubserver.member.domain.entity;

import com.example.ifclubserver.post.domain.entity.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "post_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public PostMember(Post post, Member member) {
        this.post = post;
        this.member = member;
    }
}
