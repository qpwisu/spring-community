//package com.hany.springcommunity.repository;
//
//import com.hany.springcommunity.entity.Comment;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//public interface CommentRepository extends JpaRepository<Comment, UUID> {
//    List<Comment> findByPostId(UUID postId);
//    Optional<Comment> findById(UUID commentId);
//}