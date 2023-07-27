package com.hany.springcommunity.dto.comment.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CommentDeleteResponse {
        @Schema(description = "댓글 삭제 성공 여부", example = "true")
        private boolean result;
}
