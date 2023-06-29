package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//게시글 전체 가져오기
	ArrayList<BoardDto> selectAll(int startRow, int endRow);

	BoardDto selectOne(int bno);

	void insertOne(BoardDto bdto);

	void deleteOne(int bno);

	//게시글 1개 수정
	void updateOne(BoardDto bdto);

	//게시글 Bstep 1씩 증가
	void updateBstepCount(BoardDto bdto);

	//게시글 답변달기
	void insertReplyOne(BoardDto bdto);

	//게시글 전체 개수 
	int selectListCount();

	
}
