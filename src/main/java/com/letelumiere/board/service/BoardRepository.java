package com.letelumiere.board.service;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.letelumiere.board.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query(value = "SELECT * FROM board WHERE no = :no", nativeQuery = true)
    Optional<Board> getContent(@Param("no") int no);

}
