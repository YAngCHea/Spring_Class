package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                //getter/setter
@NoArgsConstructor   //기본생성자
@AllArgsConstructor  //전체생성자
public class MemberDto {

	private String id,pw,name,phone,gender;
	private String[] hobbys;
	private String hobby;
}
