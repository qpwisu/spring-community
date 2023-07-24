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
public class Board {
    @Column(nullable = false)
    private String title;
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
    private UUID id; //게시글의 uuid

    @Builder
    private Board(Member author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public void modify(String title, String content) {
        this.title = title;
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
