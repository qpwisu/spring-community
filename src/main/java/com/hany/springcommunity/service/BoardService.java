package com.hany.springcommunity.service;

import com.hany.springcommunity.dto.board.request.BoardCreateRequest;
import com.hany.springcommunity.dto.board.request.BoardUpdateRequest;
import com.hany.springcommunity.dto.board.response.BoardInfoResponse;
import com.hany.springcommunity.dto.member.response.MemberInfoResponse;
import com.hany.springcommunity.entity.Board;
import com.hany.springcommunity.entity.Member;
import com.hany.springcommunity.repository.BoardRepository;
import com.hany.springcommunity.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public BoardInfoResponse getBoard(UUID id) {
        return boardRepository.findById(id)
                .map(BoardInfoResponse::toDto)
                .orElseThrow(()-> new NoSuchElementException("존재하지 않는 게시글입니다"));
    }

    @Transactional
    public BoardInfoResponse createBoard(BoardCreateRequest request) {
        // 토큰으로 사용자 가져오기
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String id = auth.getName();
        Member member = memberRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new NoSuchElementException("해당 회원을 찾을 수 없습니다."));
        Board board = boardRepository.save(Board.from(request,member));
        return BoardInfoResponse.toDto(board);
    }

//    @Transactional
//    public BoardRepository updateBoard(UUID id, BoardUpdateRequest request) {
//        // TODO: Update Post and return PostResponse
//    }
//
//    @Transactional
//    public void deleteBoard(UUID id) {
//        // TODO: Delete Post
//    }
}