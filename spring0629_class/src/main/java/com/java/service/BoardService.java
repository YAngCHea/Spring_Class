package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;
import com.java.dto.CommentDto;

public interface BoardService {

	//게시글 전체 가져오기
	ArrayList<BoardDto> selectAll();

	//게시글 1개 가져오기
	BoardDto selectOne(int bno);

	//하단댓글 전체 가져오기
	ArrayList<CommentDto> selectComAll(int bno);

	CommentDto commentInsert(CommentDto comDto);

	

	
	

}
