package com.java.service;

import java.util.ArrayList;

import com.java.dto.IncomeDto;

public interface IncomeService {

	//매출액 전체 가져오기
	ArrayList<IncomeDto> selectAll(int year);


}
