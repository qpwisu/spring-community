package com.hany.springcommunity.service;

import com.hany.springcommunity.dto.board.request.BoardCreateRequest;
import com.hany.springcommunity.dto.board.request.BoardUpdateRequest;
import com.hany.springcommunity.dto.board.response.*;
import com.hany.springcommunity.dto.member.response.MemberInfoResponse;
import com.hany.springcommunity.entity.Board;
import com.hany.springcommunity.entity.Category;
import com.hany.springcommunity.entity.Member;
import com.hany.springcommunity.repository.BoardRepository;
import com.hany.springcommunity.repository.CategoryRepository;
import com.hany.springcommunity.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;
    @Transactional(readOnly = true)
    public BoardInfoResponse getBoard(Long id) {
        return boardRepository.findById(id)
                .map(BoardInfoResponse::toDto)
                .orElseThrow(()-> new NoSuchElementException("존재하지 않는 게시글입니다"));
    }

    @Transactional(readOnly = true)
    public BoardListPage getBoardsByCategory(String category_name, Pageable pageable) {
        if(!categoryRepository.existsByName(category_name)){
            throw new NoSuchElementException("존재하지 않는 카테고리입니다");
        }
        Page<Board> page = boardRepository.findByCategory_Name(category_name, pageable);

        List<BoardListResponse> boards = page.stream()
                .map(BoardListResponse::toDto)
                .collect(Collectors.toList());

        BoardListPage response = new BoardListPage();
        response.setBoards(boards);
        response.setCurrentPage(page.getNumber());
        response.setTotalPages(page.getTotalPages());

        return response;
    }

    @Transactional
    public BoardInfoResponse createBoard(BoardCreateRequest request) {
        // 토큰으로 사용자 가져오기
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String id = auth.getName();
        String category_name = request.getCategory();
        Category category = categoryRepository.findByName(category_name)
                .orElseThrow(() -> new NoSuchElementException("해당 카테고리를 찾을 수 없습니다"));
        Member member = memberRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new NoSuchElementException("해당 회원을 찾을 수 없습니다."));
        System.out.println(category.toString());
        System.out.println(member.toString());
        System.out.println(Board.from(request,member,category).toString());
        Board board = boardRepository.save(Board.from(request,member,category));
        return BoardInfoResponse.toDto(board);
    }

    @Transactional
    public BoardUpdateResponse updateBoard(BoardUpdateRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String id = auth.getName();
        Member currentMember = memberRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new NoSuchElementException("현재 사용자를 찾을 수 없습니다."));

        Board board = boardRepository.findById(request.getId())
                .orElseThrow(() -> new NoSuchElementException("게시글이 존재하지 않습니다."));

        if (!board.getAuthor().equals(currentMember)) {
            throw new AccessDeniedException("게시글 수정 권한이 없습니다.");
        }
        board.modify(request.getTitle(), request.getContent());
        boardRepository.save(board);
        return BoardUpdateResponse.toDto(true, board);
    }
    @Transactional
    public BoardDeleteResponse deleteBoard(Long boardId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String id = auth.getName();
        Member currentMember = memberRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new NoSuchElementException("현재 사용자를 찾을 수 없습니다."));

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchElementException("게시글이 존재하지 않습니다."));

        if (!board.getAuthor().equals(currentMember)) {
            throw new AccessDeniedException("게시글 수정 권한이 없습니다.");
        }
        boardRepository.delete(board);
        BoardDeleteResponse response = new BoardDeleteResponse();
        response.setResult(true);
        return response;
    }
}