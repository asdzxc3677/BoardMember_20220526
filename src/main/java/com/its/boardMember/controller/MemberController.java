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
            return "redirect:/board/paging"; // "redirect: 역할은 /board/paging" <-- 로그인을 했을때 이 주소로 이동시키는 역할이다.
        }else {
            return "memberPages/login";
        }
    }


    @GetMapping("findAll") //관리자용 회원정보 Model 역할: 리턴한 정보를 리턴할 페이지로 넘길수 있다.
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

    @GetMapping("/detail") // 개인회원정보 추가
    public String detail(HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("id");
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "memberPages/detail";
    }



    @GetMapping("/delete") // 회원삭제
    public String delete(@RequestParam("id") Long id, HttpSession session) {
        System.out.println("id = " + id);
        boolean deleteResult = memberService.delete(id);
        String loginId = (String) session.getAttribute("loginId"); // 관리자가 삭제했을때 로그아웃 처리 안되게 하는 문법
        if (deleteResult) {
            if (loginId.equals("admin")) { // admin 일때 로그아웃이 안되고
                return "/memberPages/list";
            } else {
                session.removeAttribute("loginId");
                //removeAttribute 기능: 로그아웃 하는기능 admin 아니고 개인 회원일때 로그아웃이 되어버린다.
                return "index";
            }
        } else {
            return "delete-fail"; // 삭제 실패 했을때 이동하는 페이지
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
            return "redirect:/member/detail"; // 개인회원이 수정처리했을때 개인 목록만 보이게 처리로 수정함
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
        return "index";
    }









}



