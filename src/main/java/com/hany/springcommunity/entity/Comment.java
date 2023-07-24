package com.hany.springcommunity.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Comment {
    @Column(nullable = false)
    private String content;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private Integer likesCount = 0;
    private Integer commentsCount = 0;
    private Boolean isModified = false;
    @ManyToOne
    private Member author;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Builder
    private Comment(Member author, String content) {
        this.author = author;
        this.content = content;
    }

    public void modify(String content) {
        this.content = content;
        this.isModified = true;
    }

    public void incrementLikes() {
        this.likesCount++;
    }

    public void incrementComments() {
        this.commentsCount++;
    }
}
