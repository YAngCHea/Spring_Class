package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDto {

	private int bno;
	private String id;
	private String btitle;
	private String bcontent;
	private Timestamp bdate;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bfile;   //파일이름 저장
	private String[] bfiles;  //list출력할 때 사용함
	private int remainDate;    //DB에서 계산을 해서 가져오는 것 : xml에서 쿼리문으로 불러오는것이다 : 이름을 임의로 정해서 불러오는것! : 안불러오면 그냥 null값
	
	
	
	
	
}
