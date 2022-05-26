package com.its.boardMember.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class BoardDTO {
    private Long id;
    private String boardTitle; //글제목
    private String boardWriter; //작성자
    private String boardPassword; //비번
    private String boardContents; //내용
    private int boardHits; //조회수
    private Timestamp boardCreatedDate; //파일이 생성된 날짜
    private MultipartFile boardFile; //saveFile.jsp 에서 컨트롤러로 넘어올때 파일을 담아오는 용도
    private String boardFileName; //상세조회 등을 할때 파일 이름을 담을 용도

}
