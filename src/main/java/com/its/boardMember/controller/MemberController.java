package com.its.boardMember.controller;

import com.its.boardMember.dto.MemberDTO;
import com.its.boardMember.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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






}
