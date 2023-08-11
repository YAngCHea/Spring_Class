package com.java.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

@Controller
public class MemberController {

	@Autowired HttpSession session;
	
	@Autowired MemberService memberService;
	
	@GetMapping("/member/memberModify")
	public String memberModify(Model model) {
		String id = (String) session.getAttribute("sessionId");
		//회원 1명 가져오기(회원정보수정)
		MemberDto mdto = memberService.selectOneM(id);
		model.addAttribute("mdto",mdto);
		
		return "member/memberModify";
	}
	
	
	
	
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	@GetMapping("/member/join01")
	public String join01() {
		return "member/join01";
	}
	@GetMapping("/member/join02_info")
	public String join02_info() {
		return "member/join02_info";
	}
	
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate(); //섹션종료
		String resultCode="s_logout"; 
		return "redirect:/?resultCode="+resultCode;
	}
	
	@PostMapping("/member/login")
	public String login(String id,String pw, Model model) {
		System.out.println("controller id : "+id);
		System.out.println("controller pw : "+pw);
		
		//회원 1명 가져오기(로그인)
		String resultCode = memberService.selectOne(id,pw);
		if(resultCode.equals("s_login")) {
			return "redirect:/?resultCode="+resultCode;
		}else {
			model.addAttribute("resultCode",resultCode);  //f_login
			System.out.println("controller resultCode2 : "+resultCode);
		}
		
		return "member/login";
	}
}