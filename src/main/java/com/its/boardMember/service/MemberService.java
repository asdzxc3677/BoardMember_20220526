package com.its.boardMember.service;

import com.its.boardMember.dto.MemberDTO;
import com.its.boardMember.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public boolean save(MemberDTO memberDTO) {
        int saveResult = memberRepository.save(memberDTO);
        if(saveResult > 0){
            return true;
        }else {
            return false;
        }
    }


    public MemberDTO login(MemberDTO memberDTO) {
        MemberDTO loginMember = memberRepository.login(memberDTO);
        return loginMember;
    }
}
