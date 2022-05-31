package com.its.boardMember.controller;

import com.its.boardMember.dto.BoardDTO;
import com.its.boardMember.dto.CommentDTO;
import com.its.boardMember.dto.PageDTO;
import com.its.boardMember.service.BoardService;
import com.its.boardMember.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService; //쓴이유 댓글목록을 가져가기 하기 위해 선언을 하였다.

    @GetMapping("/saveFile") //글작성화면(파일)
    public String saveFileForm(){
        return "boardPages/saveFile";
    }

    @PostMapping("/saveFile")//파일첨부 글작성 처리
    public String saveFile(@ModelAttribute BoardDTO boardDTO) throws IOException{
        boardService.saveFile(boardDTO);
        return "redirect:/board/paging";
    }

    @GetMapping("/findAll") //글목록
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardPages/list";
    }

    @GetMapping("/paging")  //페이징 처리
    public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model) {
        List<BoardDTO> boardList = boardService.pagingList(page);
        PageDTO paging = boardService.paging(page);
        model.addAttribute("boardList", boardList);
        model.addAttribute("paging", paging);
        return "boardPages/pagingList";
    }

    @GetMapping("/detail") //상세조회
    public String findById(@RequestParam("id") Long id, Model model,
                           @RequestParam(value = "page",required = false,defaultValue = "1")int page){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);
        model.addAttribute("page",page);
        //댓글목록
        List<CommentDTO> commentDTOList = commentService.findAll(id);
        model.addAttribute("commentList",commentDTOList);
        return "boardPages/detail";
    }

    @GetMapping("/passwordCheck") //비밀번호 체크 페이지
    public String passwordCheck(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);
        return "boardPages/passwordCheck";
    }

    @GetMapping("/delete") //삭제처리
    public String delete(@RequestParam("id") Long id){
        boardService.delete(id);
        return "redirect:/board/findAll";
    }
    


}
