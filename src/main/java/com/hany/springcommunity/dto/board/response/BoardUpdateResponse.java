package com.hany.springcommunity.dto.board.response;

import com.hany.springcommunity.entity.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BoardUpdateResponse {
    @Schema(description = "게시판 정보 수정 성공 여부", example = "true")
    private boolean result;

    @Schema(description = "게시글", example = "게시글")
    private BoardInfoResponse boardInfo;



    public static BoardUpdateResponse toDto(boolean result, Board board) {
        BoardUpdateResponse response = new BoardUpdateResponse();
        response.setResult(result);
        response.setBoardInfo(BoardInfoResponse.toDto(board));
        return response;
    }
}
