package com.hany.springcommunity.dto.board.response;

import lombok.Data;

import java.util.List;

@Data
public class BoardListPage {
    private List<BoardListResponse> boards;
    private int currentPage;
    private int totalPages;
    // 필요에 따라 다른 페이지네이션 관련 필드를 추가할 수 있습니다.
}