package com.java.mapper;

import java.util.ArrayList;


import org.apache.ibatis.annotations.Mapper;

import com.java.dto.IncomeDto;

@Mapper
public interface IncomeMapper {

	//매출액 전체 가져오기
	ArrayList<IncomeDto> selectAll(int year);

}
