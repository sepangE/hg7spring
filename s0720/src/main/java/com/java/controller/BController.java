package com.java.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.Board;
import com.java.service.BService;

@Controller
@RequestMapping("/board")
public class BController {
	
	@Autowired
	BService bservice;
	
	@RequestMapping("/blist")
	public String blist(@RequestParam(defaultValue = "1")int page, Model model, String category, String s_word) {
		HashMap<String, Object> map = bservice.selectAll(page,category,s_word);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("listCount", map.get("listCount"));
		model.addAttribute("maxPage", map.get("maxPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("startRow", map.get("startRow"));
		model.addAttribute("endRow", map.get("endRow"));
		model.addAttribute("page", map.get("page"));
		model.addAttribute("category", map.get("category"));
		model.addAttribute("s_word", map.get("s_word"));
		
		System.out.println("카테고리 : "+ category);
		System.out.println("검색어 : "+ s_word);
//		System.out.println("page : "+ map.get("page"));
//		System.out.println("startRow : "+ map.get("startRow"));
//		System.out.println("endRow : "+ map.get("endRow"));
		return "board/blist";
	}
	
	
	@RequestMapping("/bread")
	public String bread(int page, int bno, Model model, 
			String category, String s_word) {
		HashMap<String,Object> map = bservice.selectOne(bno);
		model.addAttribute("board", map.get("board"));
		model.addAttribute("prev", map.get("prev"));
		model.addAttribute("next", map.get("next"));
		
		model.addAttribute("category", category);
		model.addAttribute("s_word", s_word);
		model.addAttribute("page", page);
		return "board/bread";
	} // bread
	
	
	@GetMapping("/breply")
	public String breply(String category, String s_word, int bno, int page, Model model) {
		HashMap<String, Object> map = bservice.selectOne(bno);
		model.addAttribute("board", map.get("board"));
		model.addAttribute("category", category);
		model.addAttribute("s_word", s_word);
		model.addAttribute("page", page);
		return "board/breply";
	}
	
	@PostMapping("/breply")
	public String dobreply(Model model, String category, String s_word, int page, Board b, @RequestParam MultipartFile file) throws UnsupportedEncodingException {
		String fileName="";
		// 파일이 있을경우 저장
		if(!file.isEmpty()) {
			String ori_fileName = file.getOriginalFilename();// 실제 파일이름
			UUID uuid = UUID.randomUUID(); // 랜덤숫자 생성
			fileName = uuid+"_"+ori_fileName; // 파일이름 변경(중복방지)
			System.out.println(fileName);
			String uploadUrl = "c:/upload/"; // 파일 업로드 위치
			File f = new File(uploadUrl+fileName);
			try {
				file.transferTo(f); // 파일 저장
			} catch(Exception e) {e.printStackTrace();}
		}
		b.setBfile(fileName); // write일땐 트라이 밖에 modi일땐 안에
		bservice.replyOne(b);
		s_word = URLEncoder.encode(s_word,"utf-8");
		return "redirect:blist?page="+page+"&category="+category+"&s_word="+s_word;
	}
	
	@GetMapping("/bwrite")
	public String bwrite() {
		return "board/bwrite";
	}
	
	@PostMapping("/bwrite")
	public String dobwrite(Board b, @RequestParam MultipartFile file) {
		String fileName="";
		// 파일이 있을경우 저장
		if(!file.isEmpty()) {
			String ori_fileName = file.getOriginalFilename();// 실제 파일이름
			UUID uuid = UUID.randomUUID(); // 랜덤숫자 생성
			fileName = uuid+"_"+ori_fileName; // 파일이름 변경(중복방지)
			System.out.println(fileName);
			String uploadUrl = "c:/upload/"; // 파일 업로드 위치
			File f = new File(uploadUrl+fileName);
			try {
				file.transferTo(f); // 파일 저장
			} catch(Exception e) {e.printStackTrace();}
		}
		b.setBfile(fileName); // write일땐 트라이 밖에 modi일땐 안에
		bservice.insertOne(b);
		return "redirect:blist";
	}
}
