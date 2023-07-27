package com.hany.springcommunity.dto.comment.response;
import com.hany.springcommunity.entity.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CommentUpdateResponse {
    @Schema(description = "댓글 정보 수정 성공 여부", example = "true")
    private boolean result;

    @Schema(description = "댓글 제목", example = "제목 예시")
    private String title;

    @Schema(description = "댓글 내용", example = "내용 예시")
    private String content;

    public static CommentUpdateResponse toDto(boolean result, Comment comment) {
        CommentUpdateResponse response = new CommentUpdateResponse();
        response.setResult(result);
        response.setContent(comment.getContent());
        return response;
    }
}
