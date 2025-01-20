package com.letelumiere.board.service;

import java.util.Date;
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
        Date date = new Date(System.currentTimeMillis());
        

        var content = new Board(
            board.getNo(),
            board.getTitle(),
            board.getWriter(),
            board.getContent(),
            date,
            date
        );

        return boardRepository.save(content);
    }

    public Board updateContent(Board board){
        var content = boardRepository.getContent(board.getNo()).orElseThrow(null);

        System.out.println(content.toString());
        content.setContent(board.getContent());
        content.setUpdDate(new Date(System.currentTimeMillis()));

        return boardRepository.save(content);
    }

    public void deleteContent(int no){
        var content = boardRepository.getContent(no).orElseThrow(null);
        boardRepository.delete(content);
    }
}

