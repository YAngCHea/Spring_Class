package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {

	//로그인하기
	MemberDto selectLogin(String id, String pw);

}
