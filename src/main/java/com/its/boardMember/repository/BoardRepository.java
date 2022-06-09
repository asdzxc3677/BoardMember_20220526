package com.its.boardMember.repository;

import com.its.boardMember.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {

    @Autowired
    private SqlSessionTemplate sql;

    public void saveFile(BoardDTO boardDTO) { //파일 글작성 처리
        sql.insert("Board.saveFile",boardDTO);
    }


    public int boardCount() {
        return sql.selectOne("Board.count");
    } // 전체 페이지수 및 페이지번호

    public List<BoardDTO> pagingList(Map<String, Integer> pagingParam) { // 글목록(페이징리스트)
        return sql.selectList("Board.pagingList",pagingParam);
    }

    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);
    } //조회수증가

    public BoardDTO findById(Long id) {
        return sql.selectOne("Board.findById", id);
    } //상세정보

    public void delete(Long id) {
        sql.delete("Board.delete", id);
    } //글삭제

    public List<BoardDTO> findAll() { //원래 계획에 없던 목록처리 추가됨
        return sql.selectList("Board.findAll");
    }

    public void update(BoardDTO boardDTO) {
        sql.update("Board.update",boardDTO);
    }//수정처리

    public List<BoardDTO> search(Map<String, String> searchParam) {
        return sql.selectList("Board.search",searchParam);
    }
    //검색처리
}
