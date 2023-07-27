package com.hany.springcommunity.dto.board.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.Data;

@Data
public class BoardCreateRequest {
    @Schema(description = "게시글 제목", example = "게시글 제목 예시")
    private String title;

    @Schema(description = "게시글 내용", example = "게시글 내용 예시")
    private String content;
}