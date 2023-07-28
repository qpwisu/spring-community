package com.hany.springcommunity.controller;

import com.hany.springcommunity.dto.ApiResponse;
import com.hany.springcommunity.dto.board.request.BoardCreateRequest;
import com.hany.springcommunity.security.UserAuthorize;
import com.hany.springcommunity.service.BoardService;
import com.hany.springcommunity.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    @GetMapping("view/{category}/{board_id}")
    public ApiResponse getBoardInfo(@RequestParam String category, @RequestParam Long board_id){
        return ApiResponse.success(boardService.getBoard(board_id));
    }

    // request param애 preable을 입력해서 받아옴
    @Operation(summary = "게시글 목록 조회")
    @GetMapping("lists/{category}")
    public ApiResponse getBoardList(@RequestParam String category, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        return ApiResponse.success(boardService.getBoardsByCategory(category,pageable));
    }

    @Operation(summary = "게시글 생성")
    @PostMapping
    public ApiResponse createBoard( @RequestBody BoardCreateRequest request){
        return ApiResponse.success(boardService.createBoard(request));
    }

}
