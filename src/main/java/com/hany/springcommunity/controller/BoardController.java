package com.hany.springcommunity.controller;

import com.hany.springcommunity.dto.ApiResponse;
import com.hany.springcommunity.dto.board.request.BoardCreateRequest;
import com.hany.springcommunity.security.UserAuthorize;
import com.hany.springcommunity.service.BoardService;
import com.hany.springcommunity.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "게시판 API")
@RequiredArgsConstructor
//@UserAuthorize
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    @Operation(summary = "게시글 조회")
    @GetMapping
    public ApiResponse getBoardInfo(UUID board_id){
        return ApiResponse.success(boardService.getBoard(board_id));
    }

    @Operation(summary = "게시글 조회")
    @PostMapping
    public ApiResponse createBoard( @RequestBody BoardCreateRequest request){
        return ApiResponse.success(boardService.createBoard(request));
    }
}
