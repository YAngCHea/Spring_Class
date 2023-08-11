package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.java.dto.BoardDto;
import com.java.dto.Search;

public interface BoardService {

	//게시글 전체가져오기
	HashMap<String,Object> selectAll(int page, Search search);

	//게시글 1개가져오기
	HashMap<String, Object> selectOne(int bno);

	//게시글 1개저장
	void insertOne(BoardDto bdto);

	//게시글 1개삭제
	void deleteOne(int bno);

	//게시글 1개수정
	void updateOne(BoardDto bdto);

	//게시글 답변달기
	void insertReplyOne(BoardDto bdto);

}