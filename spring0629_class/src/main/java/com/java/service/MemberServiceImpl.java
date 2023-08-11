package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.mapper.MemberMapper;

@Service       //ioc에 넣으려고 붙인다
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override  //로그인 확인
	public MemberDto selectLogin(MemberDto memberDto) {
		MemberDto mdto = memberMapper.selectLogin(memberDto);
		return mdto;
	}

	
}
