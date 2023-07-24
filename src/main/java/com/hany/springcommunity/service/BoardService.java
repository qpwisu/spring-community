package com.hany.springcommunity.service;

import com.hany.springcommunity.dto.board.request.BoardCreateRequest;
import com.hany.springcommunity.dto.board.request.BoardUpdateRequest;
import com.hany.springcommunity.dto.board.response.BoardResponse;
import com.hany.springcommunity.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository postRepository;

    @Transactional(readOnly = true)
    public BoardRepository getPost(UUID id) {
        return postRepository.findById(id)
                .map(BoardRepository::from)
                .orElseThrow(() -> new NoSuchElementException("Post does not exist."));
    }

    @Transactional
    public BoardRepository createPost(BoardCreateRequest request) {
        // TODO: Create Post and return PostResponse
    }

    @Transactional
    public BoardRepository updatePost(UUID id, BoardUpdateRequest request) {
        // TODO: Update Post and return PostResponse
    }

    @Transactional
    public void deletePost(UUID id) {
        // TODO: Delete Post
    }
}