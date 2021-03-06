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
@RequestMapping("/board") // RequestMapping 역할: http 인터넷창 주소를 받아주는 역할
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
    public String saveFile(@ModelAttribute BoardDTO boardDTO) throws IOException{ //throws IOException 파일 예외처리 막아주는 문법
        boardService.saveFile(boardDTO);
        return "redirect:/board/paging";
    }

    @GetMapping("/findAll") //글목록(계획에 없던 findAll 추가 됨)
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
//        return "redirect:/member/login-form";
    }

    @GetMapping("/detail") //상세조회 @RequestParam 의미: 객체가 아닌 하나의 파라미터를 보낸다.
    public String findById(@RequestParam("id") Long id, Model model,
                           @RequestParam(value = "page",required = false,defaultValue = "1")int page){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);
        model.addAttribute("page",page);
        //댓글목록
        List<CommentDTO> commentDTOList = commentService.findAll(id);
        model.addAttribute("commentList",commentDTOList); // 모델값을 jsp파일로 보내면 거기서만 사용가능
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

    @GetMapping("/update") // 수정화면 요청
    public String updateForm(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardUpdate",boardDTO);
        return "boardPages/update";
    }

    @PostMapping("/update") // 수정처리
    public String update(@ModelAttribute BoardDTO boardDTO){
        boardService.update(boardDTO);
        return "redirect:/board/detail?id=" + boardDTO.getId(); 
    }

    @GetMapping("/search") // 검색처리
    public String search(@RequestParam("searchType") String searchType,
                         @RequestParam("q") String q, Model model){
        List<BoardDTO> searchList = boardService.search(searchType, q);
        model.addAttribute("boardList",searchList);
        return "boardPages/list";
    }
    


}
