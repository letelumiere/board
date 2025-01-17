package com.letelumiere.board.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letelumiere.board.model.Board;
import com.letelumiere.board.service.BoardService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://10.0.2.2:8080")
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
        System.out.println("update");
        ResponseEntity.ok(boardService.updateContent(data));
    }

    @DeleteMapping("/{no}")
    public void delete(@PathVariable(name = "no") int no){
        boardService.deleteContent(no);
    }
    
}


/*

 // Source code is unavailable, and was generated by the Fernflower decompiler.
package com.aloha.springrest.controller;

import com.aloha.springrest.dto.Board;
import com.aloha.springrest.service.BoardService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
   private static final Logger log = LoggerFactory.getLogger(BoardController.class);
   @Autowired
   private BoardService boardService;

   @GetMapping({"/list"})
   public String list(Model model) throws Exception {
      List<Board> boardList = this.boardService.list();
      model.addAttribute("boardList", boardList);
      return "/board/list";
   }

   @GetMapping({"/read"})
   public String read(@RequestParam("no") int no, Model model) throws Exception {
      Board board = this.boardService.select(no);
      model.addAttribute("board", board);
      return "/board/read";
   }

   @GetMapping({"/insert"})
   public String insert() {
      return "/board/insert";
   }

   @PostMapping({"/insert"})
   public String insertPro(Board board) throws Exception {
      int result = this.boardService.insert(board);
      return result > 0 ? "redirect:/board/list" : "redirect:/board/insert?error";
   }

   @GetMapping({"/update"})
   public String update(@RequestParam("no") int no, Model model) throws Exception {
      Board board = this.boardService.select(no);
      model.addAttribute("board", board);
      return "/board/update";
   }

   @PostMapping({"/update"})
   public String updatePro(Board board) throws Exception {
      int result = this.boardService.update(board);
      if (result > 0) {
         return "redirect:/board/list";
      } else {
         int no = board.getNo();
         return "redirect:/board/update?no=" + no + "&error";
      }
   }

   @PostMapping({"/delete"})
   public String delete(@RequestParam("no") int no) throws Exception {
      int result = this.boardService.delete(no);
      return result > 0 ? "redirect:/board/list" : "redirect:/board/update?no=" + no + "&error";
   }
}

 */