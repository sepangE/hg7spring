package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.Board;
import com.java.service.BService;

@Controller
@RequestMapping("/board")
public class BController {
	
	@Autowired
	BService bservice;
	
	@RequestMapping("/blist")
	public String blist(@RequestParam(defaultValue = "1")int page, Model model) {
		HashMap<String, Object> map = bservice.selectAll(page);
	//	System.out.println(list.get(0).getBtitle());
		model.addAttribute("list", map.get("list"));
		model.addAttribute("listCount", map.get("listCount"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("startRow", map.get("startRow"));
		model.addAttribute("endRow", map.get("endRow"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("maxPage", map.get("maxPage"));
		model.addAttribute("page", map.get("page"));
		
		System.out.println("maxPage : "+map.get("maxPage"));
		return "board/blist";
	}
	
	@RequestMapping("/bread")
	public String bread(int bno, Model model) {
		Board b = bservice.selectOne(bno);
		bservice.bhitUp(bno);
		model.addAttribute("board", b);
		return "board/bread";
	}
	
	@GetMapping("/bwrite")
	public String bwrite() {
		System.out.println("get mapping");
		return "board/bwrite";
	}
	
	@PostMapping("/bwrite")
	public String dobwrite(Board b, @RequestPart MultipartFile file) {
		System.out.println("post mapping");
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
		b.setBfile(fileName);
		System.out.println(b.getBfile());
		bservice.insertOne(b);
		return "redirect:blist";
	}
	
	@RequestMapping("/bdelete")
	public String bdelete(int bno) {
		bservice.deleteOne(bno);
		return "redirect:blist";
	}
	
	@GetMapping("/bmodi")
	public String bmodi(int bno, Model model) {
		System.out.println("get mapping");
		Board b = bservice.selectOne(bno);
		model.addAttribute("board", b);
		return "board/bmodi";
	}
	
	
	@PostMapping("/bmodi")
	public String dobmodi(Board b, @RequestPart MultipartFile file) {
		System.out.println("post mapping - bmodi");
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
				b.setBfile(fileName);
			} catch(Exception e) {e.printStackTrace();}
		}
		bservice.modiOne(b);
		return "redirect:blist";
	}
	
	
	@GetMapping("/breply")
	public String breply(int bno, Model model) {
		System.out.println("breply bno : "+bno);
		Board b = bservice.selectOne(bno);
		model.addAttribute("board", b);
		return "board/breply";
	}
	
	
	@PostMapping("/breply")
	public String dobreply(Board b, @RequestPart MultipartFile file) {
//		System.out.println("bno : "+b.getBno());
//		System.out.println("bgroup : "+b.getBgroup());
//		System.out.println("bindent : "+b.getBindent());
//		System.out.println("bstep : "+b.getBstep());
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
				b.setBfile(fileName);
			} catch(Exception e) {e.printStackTrace();}
		}
		bservice.replyOne(b);
		return "redirect:blist";
	}
	
	
	
	
	
}
