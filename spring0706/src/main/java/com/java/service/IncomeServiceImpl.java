package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.IncomeDto;
import com.java.mapper.IncomeMapper;

@Service
public class IncomeServiceImpl implements IncomeService{

	@Autowired IncomeMapper incomeMapper;
	
	@Override //매출액 전체 가져오기
	public ArrayList<IncomeDto> selectAll(int year) {
		ArrayList<IncomeDto> list = incomeMapper.selectAll(year);
		return list;
	}

}
