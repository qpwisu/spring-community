//package com.hany.springcommunity.service;
//
//import com.hany.springcommunity.dto.comment.request.CommentCreateRequest;
//import com.hany.springcommunity.dto.comment.request.CommentUpdateRequest;
//import com.hany.springcommunity.dto.comment.response.CommentInfoResponse;
//import com.hany.springcommunity.repository.CommentRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.NoSuchElementException;
//import java.util.UUID;
//
//@RequiredArgsConstructor
//@Service
//public class CommentService {
//    private final CommentRepository commentRepository;
//
//    @Transactional(readOnly = true)
//    public CommentInfoResponse getComment(UUID id) {
//        return commentRepository.findById(id)
//                .map(CommentInfoResponse::toDto)
//                .orElseThrow(() -> new NoSuchElementException("Comment does not exist."));
//    }
//
//    @Transactional
//    public CommentInfoResponse createComment(CommentCreateRequest request) {
//        // TODO: Create Comment and return CommentResponse
//    }
//
//    @Transactional
//    public CommentInfoResponse updateComment(UUID id, CommentUpdateRequest request) {
//        // TODO: Update Comment and return CommentResponse
//    }
//
//    @Transactional
//    public void deleteComment(UUID id) {
//        // TODO: Delete Comment
//    }
//}