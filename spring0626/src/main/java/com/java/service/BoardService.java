package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	//게시글 전체 가져오기
	ArrayList<BoardDto> selectAll();

	//게시글 1개 가져오기
	BoardDto selectOne(int bno);

	//게시글 1개 저장
	void insertOne(BoardDto bdto);

}
