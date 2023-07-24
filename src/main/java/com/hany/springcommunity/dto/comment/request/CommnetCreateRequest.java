package com.hany.springcommunity.dto.comment.request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CommnetCreateRequest {
    @Schema(description = "댓글 내용", example = "댓글 내용 예시")
    private String content;
}