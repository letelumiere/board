package com.letelumiere.board.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import com.letelumiere.board.model.Board;
import com.letelumiere.board.service.BoardService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    @Autowired
    private final BoardService boardService;

    @GetMapping("/list")
    public ResponseEntity<List<Board>> list(){
        return ResponseEntity.ok(boardService.getList());
    }

    @GetMapping("/read/{no}")
    public ResponseEntity<Optional<Board>> read(@PathVariable("no") int no){
        return ResponseEntity.ok(boardService.getContent(no));
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Board> insert(@RequestBody Board data){
        return ResponseEntity.ok(boardService.insertContent(data));
    }

    @PutMapping("/update")
    public void update(@RequestBody Board data){
        ResponseEntity.ok(boardService.updateContent(data));
    }

    @DeleteMapping("/{no}")
    public void delete(@PathVariable(name = "no") int no){
        
    }
    
}
