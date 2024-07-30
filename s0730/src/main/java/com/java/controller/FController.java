package com.java.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.Board;

@Controller
public class FController {
	
	@RequestMapping("/")
	public String index() {
		return "/index";
	}
	
	@RequestMapping("/map1")
	public String map1() {
		return "/map1";
	}
	
	@RequestMapping("/map2")
	public String map2() {
		return "/map2";
	}
	
	@RequestMapping("/form1")
	public String form1() {
		return "/form1";
	}
	
	
	@PostMapping("/doForm1")
	public String doForm1(Board b,@RequestPart MultipartFile file, Model model) throws Exception {
		String fileName="";
		// 파일을 upload에 저장
		if(!file.isEmpty()) {
			String ori_fileName = file.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			fileName = uuid+"_"+ori_fileName;
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl+fileName);
			file.transferTo(f);
		}
		model.addAttribute("fileName",fileName);
		model.addAttribute("btitle",b.getBtitle());
		return "/fileCheck";
	}
	
	@RequestMapping("/form2")
	public String form2() {
		return "/form2";
	}
	
	@RequestMapping("/doForm2")
	public String doForm2(Board b, List<MultipartFile> files,Model model) throws Exception {
		
		String fName="";
		String fileName="";
		int i = 0;
		for(MultipartFile file: files) {
			//System.out.println(file.getOriginalFilename());
			String ori_fileName = file.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			fileName = uuid+"_"+ori_fileName;
			String uploadUrl="c:/upload/";
			File f = new File(uploadUrl+fileName);
			file.transferTo(f);
			if(i==0) fName += fileName;
			else  fName += ", "+ fileName;
			i++;
		}
		String[] splitNames = fName.split(", ");
		b.setBfile(fName);
		b.setBfiles(splitNames);
		model.addAttribute("board", b);
		return "/fileCheck2";
	}//doForm2
	
	
	@RequestMapping("/form3")
	public String form3() {
		return "/form3";
	}
	
	
	
	
}
