package com.its.boardMember.controller;

import com.its.boardMember.dto.CommentDTO;
import com.its.boardMember.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

@Autowired
    private CommentService commentService;

    //댓글등록
    @PostMapping("/save")
    public @ResponseBody List<CommentDTO> save(@ModelAttribute CommentDTO commentDTO){
        commentService.save(commentDTO);
        List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId()); //2.
        return commentDTOList;
    }

    @GetMapping("/delete")
    public @ResponseBody List<CommentDTO> delete(@RequestParam("id") Long id,
                                                 @RequestParam("boardId") Long boardId) {
        commentService.delete(id);
        List<CommentDTO> commentDTOList = commentService.findAll(boardId);
        return commentDTOList;
    }
}
