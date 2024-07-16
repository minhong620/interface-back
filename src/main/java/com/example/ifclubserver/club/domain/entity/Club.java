package com.example.ifclubserver.club.domain.entity;

import com.example.ifclubserver.common.entitiy.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Club extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "leader", nullable = false)
    private String leader;

    public void updateName(String newName) {
        this.name = newName;
    }

    public void updateContent(String newContent) {
        this.content = newContent;
    }

    public void updateImageUrl(String newImage_url) {
        this.image_url = newImage_url;
    }

    public void updateLeader(String newLeader) {
        this.leader = newLeader;
    }
}
