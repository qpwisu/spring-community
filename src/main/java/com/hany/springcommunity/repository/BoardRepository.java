package com.hany.springcommunity.repository;
import com.hany.springcommunity.entity.Board;
import com.hany.springcommunity.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, UUID> {
//    List<Board> findByTitleContaining(String title);
    Optional<Board> findByCategoryAndId(String category,Long board_id);
    Optional<Board> findById(Long Id);
    Page<Board> findByCategory_Name(String name, Pageable pageable);
}