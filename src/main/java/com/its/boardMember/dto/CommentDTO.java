package com.its.boardMember.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentDTO {
    private Long id; // 댓글 관리번호
    private String commentWriter; //작성자
    private String commentContents; //댓글내용
    private Long boardId; // 글번호
    private Timestamp commentCreatedDate; // 댓글작성날짜시간

}
