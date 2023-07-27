package com.hany.springcommunity.dto.board.response;
import com.hany.springcommunity.dto.member.response.MemberInfoResponse;
import com.hany.springcommunity.entity.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class BoardInfoResponse {
    @Schema(description = "게시글 ID", example = "123e4567-e89b-12d3-a456-426614174000")
    private Long id;

    @Schema(description = "게시글 제목", example = "게시글 제목 예시")
    private String title;

    @Schema(description = "게시글 내용", example = "게시글 내용 예시")
    private String content;

    @Schema(description = "작성자 ID", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID authorId;

    @Schema(description = "게시글 작성일", example = "2023-07-24T10:15:30")
    private LocalDateTime createdAt;

    @Schema(description = "좋아요 수", example = "0")
    private Integer likesCount = 0;
    @Schema(description = "댓글 수", example = "0")
    private Integer commentsCount = 0;
    @Schema(description = "수정 유무", example = "false")
    private Boolean isModified = false;
    public static BoardInfoResponse toDto(Board board){
        return BoardInfoResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getTitle())
                .authorId(board.getAuthor().getId())
                .createdAt(board.getCreatedAt())
                .likesCount(board.getLikesCount())
                .commentsCount(board.getCommentsCount())
                .isModified(board.getIsModified())
                .build();
    }

}