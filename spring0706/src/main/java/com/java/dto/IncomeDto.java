package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IncomeDto {
	
	private int ino;
	private String iyear;
	private String imonth;
	private int iincome;

}
