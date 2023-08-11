package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}

	//회원 인증하기
	@GetMapping("/member/step01")
	public String step01() {
		return "member/step01";
	}

	@GetMapping("/member/step02")
	public String step02() {
		return "member/step02";
	}
	
	@GetMapping("/member/step03")    //회원가입 페이지로
	public String step03() {
		return "member/step03";
	}
	
	@PostMapping("/member/step03")   //회원가입 저장시키기
	public String step03(Model model) {
		return "member/step03";
	}
}
