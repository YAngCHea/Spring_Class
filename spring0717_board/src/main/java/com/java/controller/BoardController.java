package com.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.dto.PageDto;
import com.java.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;

	@GetMapping("/board/boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
	@PostMapping("/board/boardWrite")
	public String boardWrite(BoardDto boardDto,List<MultipartFile> files, Model model) {
		//게시글 1개저장
		boardService.insertBoard(boardDto,files);
		String result="i_success";
		return "redirect:/board/boardList?result="+result;
	}
	
	
	@RequestMapping("/board/boardList")
	public String boardList(@RequestParam(defaultValue = "none") String result, PageDto pageDto, Model model) {
		System.out.println("BoardController page : "+pageDto.getPage());
		
		//게시글 전체가져오기
		HashMap<String, Object> map = boardService.selectAll(pageDto);
		model.addAttribute("list",map.get("list"));
		model.addAttribute("pageDto",map.get("pageDto"));
		model.addAttribute("result",result); //파일저장 결과변수
		
		return "board/boardList";
	}
	
	
	//ajax-----------------------------------------------------------------------------------
	/*
	 * @PostMapping("/board/reviewAjax") //ajax에 있는 type이랑 맞춰줘야한다
	 * 
	 * @ResponseBody //데이터로 넘겨준다. public BoardDto reviewAjax(int bno,PageDto
	 * pageDto) { //returntype이 String 이 아니고 BoardDto다!!! pageDto.setPage(1); //하단
	 * 넘버링이 1인것 : 1-10까지 들고와라
	 * 
	 * System.out.println("BoardController bno : "+bno);
	 * 
	 * //게시글 1개
	 * 가져오기-------------------------------------------------------------------------
	 * //BoardDto bdto = boardService.selectOne(bno); //mapper데이터 1개를 가져온다
	 * //bdto.setBfiles(bdto.getBfile().split(",")); //파일을 가져올때 ,를 기준으로 나눠서 들고와!
	 * //return bdto;
	 */		
	
	//위에있는애랑 동일한데 이친구는 아예 list로 전체를 들고온다
	@PostMapping("/board/reviewAjax")     //ajax에 있는 type이랑 맞춰줘야한다
	@ResponseBody   //데이터로 넘겨준다.
	public ArrayList<BoardDto> reviewAjax(int bno,PageDto pageDto) {   //returntype이 String 이 아니고 BoardDto다!!!
		pageDto.setPage(1);  //하단 넘버링이 1인것 : 1-10까지 들고와라
		
		System.out.println("BoardController bno : "+bno);
	//게시글 여러개 들고오기 : mapper에서 여러개 가져온다-------------------------------------------------------------------------------------
	ArrayList<BoardDto> list = boardService.selectBoardAll();   //mapper데이터 list로 가져옴
	
	//System.out.println("list"+list);
	
	return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}