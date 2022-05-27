package com.its.boardMember.service;

import com.its.boardMember.dto.MemberDTO;
import com.its.boardMember.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<MemberDTO> findAll() {
        return memberRepository.findAll();
    }

    public MemberDTO findById(Long id) {
        return memberRepository.findById(id);
    }

    public boolean delete(Long id) {
        int deleteResult = memberRepository.delete(id);
        if(deleteResult > 0){
            return true;
        }else {
            return false;
        }
    }


    public boolean update(MemberDTO memberDTO) {
        int updateResult = memberRepository.update(memberDTO);
        if(updateResult > 0){
            return true;
        }else {
            return false;
        }
    }

}
