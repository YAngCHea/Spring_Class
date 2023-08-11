package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;
import com.java.dto.PageDto;

@Mapper
public interface BoardMapper {

	//게시글 전체가져오기
	ArrayList<BoardDto> selectAll(PageDto pageDto);

	//전체게시글 수
	int selectListCount();

	//게시글 1개저장
	void insertBoard(BoardDto boardDto);

	//게시글 1개 가져오기
	BoardDto selectOne(int bno);

	//게시글 여러개 가져오기
	ArrayList<BoardDto> selectBoardAll();

}