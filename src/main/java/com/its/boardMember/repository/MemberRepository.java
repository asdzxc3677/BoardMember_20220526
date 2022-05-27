package com.its.boardMember.repository;

import com.its.boardMember.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private SqlSessionTemplate sql;

    public int save(MemberDTO memberDTO) {
        return sql.insert("Member.save",memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO) {

        return sql.selectOne("Member.login",memberDTO);
    } // selectOne 은 select 를 한개만 선택한다는 의미이다?!!

    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById",id);
    }

    public int delete(Long id) {
        return sql.delete("Member.delete",id);
    }
}
