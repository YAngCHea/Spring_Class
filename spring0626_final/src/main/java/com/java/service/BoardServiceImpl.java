package com.java.service;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.dto.BoardDto;
import com.java.mapper.BoardMapper;
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public HashMap<String,Object> selectAll(int page, String category, String s_word) {
		//게시글 전체 가져오기
		
		
		HashMap<String, Object> map = new HashMap<>();
		
		//게시글 전체개수
		int listCount = boardMapper.selectListCount(category,s_word);
		System.out.println("BoardServiceImpl selectAll listCount : "+ listCount);
		//최대페이지
		int maxPage = (int)Math.ceil((double)listCount/10); // 최대페이지(전체 게시물/10 -> 4개page)
		int startPage = (int)((page-1)/10)*10 + 1; // 시작페이지 1
		int endPage = startPage+10-1; // 마지막페이지
		
		int startRow = (page-1)*10+1; //1page : 1-10, 2page : 11-20
		int endRow = startRow+10-1;
		
		//endPage가 maxPage보다 더 크면 maxPage만 노출
		if(endPage>maxPage) endPage=maxPage;
		ArrayList<BoardDto> list = boardMapper.selectAll(startRow,endRow,category,s_word);
		
		map.put("list", list);
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("page", page);
		map.put("category", category);
		map.put("s_word", s_word);
		
		return map;
	}//selectAll
	
	@Override
	public HashMap<String, Object> selectOne(int bno) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		//조회수 1 증가
		boardMapper.updateBhitUP(bno);
		
		//게시글 1개 가져오기
		//이전 게시글 / 다음글 1개 가져오기
		BoardDto prevDto = boardMapper.selectPrevOne(bno);
		BoardDto nextDto = boardMapper.selectNextOne(bno);
		BoardDto bdto = boardMapper.selectOne(bno);
		
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		map.put("bdto", bdto);
		
		return map;
	}
	@Override
	public void insertOne(BoardDto bdto) {
		//게시글 1개 저장하기
		boardMapper.insertOne(bdto);
	}
	@Override
	public void deleteOne(int bno) {
		//게시글 1개 삭제하기
		boardMapper.deleteOne(bno);
		
	}
	@Override
	public void updateOne(BoardDto bdto) {
		//게시글 1개 수정하기
		boardMapper.updateOne(bdto);
	}
	@Override
	public void insertReplyOne(BoardDto bdto) {
		//게시글에 답변 달기
		System.out.println("service insertReplyOne : "+bdto.getBgroup());
		boardMapper.updateBstepCount(bdto);
		boardMapper.insertReplyOne(bdto);
	}
}