package com.hany.springcommunity.dto.board.request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BoardUpdateRequest {
    @Schema(description = "게시글 ID", example = "1")
    private Long id;

    @Schema(description = "게시글 제목", example = "게시글 제목 예시")
    private String title;

    @Schema(description = "게시글 내용", example = "게시글 내용 예시")
    private String content;
}