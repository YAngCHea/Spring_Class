package com.java.service;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.dto.BoardDto;
import com.java.dto.CommentDto;
import com.java.mapper.BoardMapper;
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper boardMapper;
	@Override //게시글 전체 가져오기
	public ArrayList<BoardDto> selectAll() {
		ArrayList<BoardDto> list = new ArrayList<>();
		
		//게시글 전체 가져오기
		list = boardMapper.selectAll();
		return list;
	}
	
	@Override
	public BoardDto selectOne(int bno) {
        BoardDto bdto = boardMapper.selectOne(bno);
		return bdto;
	}

	@Override  //하단댓글 전체 가져오기
	public ArrayList<CommentDto> selectComAll(int bno) {

		ArrayList<CommentDto> comList = boardMapper.selectComAll(bno);
		
		return comList;
	}
 
	//하단댓글 저장
	@Override
	public CommentDto commentInsert(CommentDto comDto) {
        //하단댓글 저장 후 
		boardMapper.commentInsert(comDto);
		System.out.println("BoardserviceImpl comDto cno"+comDto.getCno());
		System.out.println("BoardserviceImpl comDto cno"+comDto.getCdate());
        //하단댓글 1개 가져오기
        CommentDto cdto = boardMapper.selectComOne(comDto);
        
		return cdto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}