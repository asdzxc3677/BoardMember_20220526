package com.its.boardMember.repository;

import com.its.boardMember.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
