package com.java.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;

@Controller
public class FController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/form1")
	public String form1() {
		return "form1";
	}
	
	@RequestMapping("/form2")
	public String form2() {
		return "form2";
	}
	
	@RequestMapping("/doForm2")
	public String doForm2(BoardDto boardDto, List<MultipartFile> files,Model model) {
	
		String fNames="";
		int i=0;
		for(MultipartFile file : files) {
			System.out.println("doForm2 fileName : "+file.getOriginalFilename());
			if(i==0) fNames += file.getOriginalFilename();
			else fNames += "," + file.getOriginalFilename();
			i++;
		}
		System.out.println("FController fNames : " + fNames);   //1.jpg 2.jpg 3.jpg
		String[] splitNames = fNames.split(",");
		System.out.println("FController btitle : " + boardDto.getBtitle());
		
		model.addAttribute("fNames",fNames);
		model.addAttribute("splitNames",splitNames);
		model.addAttribute("btitle",boardDto.getBtitle());
		
		return "fileCheck2";
	}

	@RequestMapping("/doForm1")
	public String doForm1() {
		return "index";
	}
}
