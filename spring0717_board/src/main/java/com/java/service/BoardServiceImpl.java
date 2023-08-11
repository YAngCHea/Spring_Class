package com.java.service;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.dto.PageDto;
import com.java.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	@Override //게시글 1개저장
	public void insertBoard(BoardDto boardDto, List<MultipartFile> files) {
		
		String bfile = ""; //파일저장이름
		String tempFile = ""; //임시사용이름
		String oriFile = ""; //원본파일이름
		String[] bfiles = new String[3];
		
		for(int i=0;i<3;i++) {   //files.size()->이미지 등록개수만큼 저장
			tempFile = ""; //초기화
			if(!files.get(i).isEmpty()) {
				oriFile = files.get(i).getOriginalFilename(); //원본파일이름저장
				UUID uuid = UUID.randomUUID(); //랜덤번호
				tempFile = uuid + "_" + oriFile;  // 38749379137_1.jpg
				String uploadURL = "c:/upload/";  // 파일저장위치
				File f = new File(uploadURL+tempFile);
				try { 
					files.get(i).transferTo(f); //파일을 서버에 저장
				} catch (Exception e) { e.printStackTrace(); } 
			}//if
			
			//파일이름을 1개로 묶음
			if(i==0) bfile = tempFile;
			else bfile += ","+tempFile;     //452424_1.jpg,324134_2.jpg,341413_3.jpg
	
			// dto에 bfile이름 저장
			boardDto.setBfile(bfile); 
			
		}//for
		
		//파일이름 출력
		System.out.println("파일이름 1개로 묶은 이름 : "+bfile);
		
		//파일이름 1개로 묶은 이름 String배열로 분리
		bfiles = bfile.split(",");
		
		System.out.println("bfiles 배열 출력 : "+Arrays.toString(bfiles));
		System.out.println("bfiles 배열 개수 : "+bfiles.length);
		
		//mapper 전송 - 게시글 1개저장
		boardMapper.insertBoard(boardDto);
		
		
		
	}//게시글 1개 저장
	
	
	
	@Override //게시글 전체가져오기 - 현재페이지
	public HashMap<String, Object> selectAll(PageDto pageDto) {
		HashMap<String, Object> map = new HashMap<>();
		//페이지정보 메소드호출
		pageDto = pageMethod(pageDto);
		
		//게시글 전체가져오기
		ArrayList<BoardDto> list = boardMapper.selectAll(pageDto);
		System.out.println("BoardServiceImpl remainDate : "+list.get(0).getRemainDate());
		
		map.put("list", list);
		map.put("pageDto", pageDto);
		
		return map;
	}//
	
	
	//페이지정보 메소드
	public PageDto pageMethod(PageDto pageDto) {
		
		//전체게시글 수-142,현재페이지,최대페이지,시작페이지,끝페이지 1-시작,2,3,4,5-현재,6,7,8,9,10-끝  15-최대
		//시작번호,끝나는번호 1-10,11-20,21-30
		//전체게시글 수 저장
		pageDto.setListCount(boardMapper.selectListCount());
		// 최대 넘버링페이지
		pageDto.setMaxPage((int)Math.ceil((double)pageDto.getListCount()/10));
		// 시작 넘버링페이지
		pageDto.setStartPage((int)((pageDto.getPage()-1)/10)*10 + 1);
		// 끝 넘버링페이지
		pageDto.setEndPage(pageDto.getStartPage()+10-1);
		// 시작번호
		pageDto.setStartRow((pageDto.getPage()-1)*10+1);
		// 끝나는번호
		pageDto.setEndRow(pageDto.getStartRow()+10-1);
		
		return pageDto;
	}



	//게시글 1개 가져오기
	@Override
	public BoardDto selectOne(int bno) {
		BoardDto bdto = boardMapper.selectOne(bno); 
		return bdto;
	}



	//게시글 여러개 가져오기
	@Override
	public ArrayList<BoardDto> selectBoardAll() {
		ArrayList<BoardDto> list = boardMapper.selectBoardAll();
		
		return list;
	}


	
	
	

}