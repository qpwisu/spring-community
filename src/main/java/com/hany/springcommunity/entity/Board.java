package com.hany.springcommunity.entity;

import com.hany.springcommunity.dto.board.request.BoardCreateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GenerationType.IDENTITY for auto-incrementing ID
    private Long id; // 게시글의 ID를 Long 타입으로 변경

    @Column(nullable = false)
    private String category;

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

    public static Board from(BoardCreateRequest request, Member author) {
        return Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .category(request.getCategory())
                .author(author)
                .createdAt(LocalDateTime.now()) // Set creation time to now
                .build();
    }

    @Builder
    private Board(Member author, String title, String content, String category, LocalDateTime createdAt) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.category= category;
        this.createdAt = createdAt; // Include createdAt in the constructor
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
