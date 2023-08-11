package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.BoardDto;
import com.java.dto.CommentDto;
import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	
	@RequestMapping("/board/notice")
	public String notice(Model model) {
		ArrayList<BoardDto> list = new ArrayList<>();
		list = boardService.selectAll();
		
		model.addAttribute("list",list);
		
		return"board/notice";
	}
	
	@RequestMapping("/board/noticeView")
	public String noticeView(int bno, Model model) {
		//게시글 1개 가져오기
		BoardDto bdto = boardService.selectOne(bno);
        //하단댓글 모두 가져오기
		ArrayList<CommentDto> comList = boardService.selectComAll(bno);
		
		model.addAttribute("bdto",bdto);
		model.addAttribute("comList",comList);
		
		return"board/noticeView";
	}
	
	@RequestMapping("/board/commentInsert")
	@ResponseBody  //2.data로 리턴해서 돌려줘라!
	public CommentDto commentInsert(CommentDto comDto) {
		
		//하단댓글 저장 1개 가져오기
		//페이지자체가 변경되는게 아니고 부분만 변경된다 -> 로딩시간이 줄어든다
		System.out.println("ajax 넘어온 데이터1 : " +comDto.getCcontent());
		
		CommentDto cdto =  boardService.commentInsert(comDto);
		
		return cdto;  //1.데이터를 리턴해서 돌려줘야함
	}
	
	
	
	
	
}
