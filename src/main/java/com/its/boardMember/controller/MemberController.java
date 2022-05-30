package com.its.boardMember.controller;

import com.its.boardMember.dto.MemberDTO;
import com.its.boardMember.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/save-form") //회원가입 페이지 출력
    public String saveForm(){
        return "memberPages/save";
    }

    @PostMapping("/save") //회원가입 처리
    public String save(@ModelAttribute MemberDTO memberDTO){
        boolean saveResult = memberService.save(memberDTO);
        if(saveResult){
            System.out.println("저장성공");
            return "/memberPages/login";
        } else {
            System.out.println("저장실패");
            return "memberPages/save-fail";
        }
    }

    @GetMapping("/login-form") //로그인 페이지 출력
    public String loginForm(){
        return "memberPages/login";
    }

    @PostMapping("/login") //로그인 처리
    public String login(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session){
        System.out.println("턴트롤러 디티오"+memberDTO);
        MemberDTO loginMember = memberService.login(memberDTO);
        System.out.println("컨트롤러"+loginMember);
        if(loginMember != null){
            model.addAttribute("loginMember",loginMember);
            session.setAttribute("loginId",loginMember.getMemberId());
            session.setAttribute("id",loginMember.getId());
            return "/memberPages/main"; //나중에 main 처리로?
        }else {
            return "memberPages/login";
        }
    }

    @GetMapping("findAll") //회원정보
    public String findAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList",memberDTOList);
        return "memberPages/list";
    }

    @GetMapping("/detail-ajax") // ajax로 처리된 상세조회
    public @ResponseBody MemberDTO findByIdAjax(@RequestParam("id") Long id){
        System.out.println("id = " + id);
        MemberDTO memberDTO = memberService.findById(id);
        return memberDTO;
    }

    @GetMapping("/delete") // 회원삭제
    public String delete(@RequestParam("id") Long id) {
        System.out.println("id = " + id);
        boolean deleteResult = memberService.delete(id);
        if (deleteResult) {
            return "redirect:/member/findAll";
        } else {
            return "delete-fail";
        }
    }
//    @GetMapping("/delete")
//    public String delete(@RequestParam("id") Long id) {
//        boardService.delete(id);
//        return "redirect:/member/findAll";
//    } 삭제처리할때 간단 명료한 문법을 사용해도 괜찮다.

    @GetMapping("/update-form") //회원수정을 위해 회원정보를 받음
    public String updateForm(HttpSession session, Model model){
        Long updateId = (Long) session.getAttribute("id");
        System.out.println("updateId=" + updateId);
        MemberDTO memberDTO = memberService.findById(updateId);
        model.addAttribute("updateMember",memberDTO);
        return "memberPages/update";
    }

    @PostMapping("/update") //회원수정 처리
    public String update(@ModelAttribute MemberDTO memberDTO){
        boolean updateResult = memberService.update(memberDTO);
        if (updateResult){
            return "redirect:/member/detail?id=" + memberDTO.getId();
        }else {
            return "memberPages/update-fail";
        }
    }

    @PostMapping("/duplicate-check") //아이디 중복체크
    public @ResponseBody String duplicateCheck(@RequestParam("memberId") String memberId){
        System.out.println("memberId = " + memberId);
        String checkResult = memberService.duplicateCheck(memberId);
        return  checkResult;
    }

    @GetMapping("logout") // 로그아웃 처리
    public String logout(HttpSession session){
        session.invalidate();
        return "/memberPages/index";
    }









}



