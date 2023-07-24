package com.hany.springcommunity.dto.board.response;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class BoardInfoResponse {
    @Schema(description = "게시글 ID", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "게시글 제목", example = "게시글 제목 예시")
    private String title;

    @Schema(description = "게시글 내용", example = "게시글 내용 예시")
    private String content;

    @Schema(description = "작성자 ID", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID authorId;

    @Schema(description = "게시글 작성일", example = "2023-07-24T10:15:30")
    private LocalDateTime createdAt;
}