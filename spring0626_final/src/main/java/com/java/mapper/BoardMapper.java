package com.java.mapper;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import com.java.dto.BoardDto;
@Mapper
public interface BoardMapper {
	
	//게시글 전체 가져오기
	ArrayList<BoardDto> selectAll(int startRow, int endRow, String category, String s_word);
	//게시글 1개 가져오기
	BoardDto selectOne(int bno);
	
	//게시글 이전글
	BoardDto selectPrevOne(int bno);
	
	//게시글 다음글
	BoardDto selectNextOne(int bno);
	
	//게시글 조회수 1 증가
	void updateBhitUP(int bno);
	
	//게시글 1개 저장하기
	void insertOne(BoardDto bdto);
	
	//게시글 1개 삭제하기
	void deleteOne(int bno);
	
	//게시글 1개 수정하기
	void updateOne(BoardDto bdto);
	
	//게시글 bstep 1씩 증가
	void updateBstepCount(BoardDto bdto);
	
	//게시글에 답변 달기
	void insertReplyOne(BoardDto bdto);
	
	//게시글 전체개수
	int selectListCount(String category, String s_word);
	

	
	
	
}







