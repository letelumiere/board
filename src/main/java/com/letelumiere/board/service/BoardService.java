package com.letelumiere.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letelumiere.board.model.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getList(){
        return boardRepository.findAll();
    }

    public Optional<Board> getContent(int no){
        return boardRepository.getContent(no);
    }

    public Board insertContent(Board board){
        var content = new Board(
            board.getNo(),
            board.getTitle(),
            board.getWriter(),
            board.getContent(),
            board.getRegDate(),
            board.getUpdDate()
        );

        return boardRepository.save(content);
    }

    public Board updateContent(Board board){
        var content = boardRepository.getContent(board.getNo());
        
        return boardRepository.save(board);
    }
}

