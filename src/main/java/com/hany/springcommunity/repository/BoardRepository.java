package com.hany.springcommunity.repository;
import com.hany.springcommunity.entity.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, UUID> {
//    List<Board> findByTitleContaining(String title);
    Optional<Board> findById(Long board_id);
    List<Board> findByCategory(String category, Pageable pageable);
}