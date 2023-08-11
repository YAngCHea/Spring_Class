package com.java.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired HttpSession session;
	
	@Autowired MemberMapper memberMapper;
	
	@Override //회원 1명 가져오기(로그인)
	public String selectOne(String id, String pw) {
		String resultCode = "";
		MemberDto mdto = memberMapper.selectOne(id,pw);
		if(mdto!=null) {
			session.setAttribute("sessionId", mdto.getId());
			session.setAttribute("sessionName", mdto.getName());
			resultCode = "s_login";
		}else {
			resultCode = "f_login";
		}
		return resultCode;
	}

	@Override //회원 1명 가져오기(회원정보수정)
	public MemberDto selectOneM(String id) {
		MemberDto mdto = memberMapper.selectOneM(id);
		String[] phones = mdto.getPhone().split("-");
		mdto.setPhones(phones);
		return mdto;
	}

	

}