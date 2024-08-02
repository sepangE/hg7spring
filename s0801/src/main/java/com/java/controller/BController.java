package com.java.controller;

import java.io.File;
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
	
	@Autowired BService bservice;
	
	@RequestMapping("/notice")
	public String notice(Model model,@RequestParam(defaultValue = "1")int page,String category, String sWord) {
		HashMap<String, Object> map = bservice.selectAll(page,category,sWord);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("page", map.get("page"));
		model.addAttribute("listCount", map.get("listCount"));
		model.addAttribute("maxPage", map.get("maxPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("startRow", map.get("startRow"));
		model.addAttribute("endRow", map.get("endRow"));
		model.addAttribute("category", map.get("category"));
		model.addAttribute("sWord", map.get("sWord"));
	//	System.out.println(map.get("sWord"));
	//	System.out.println(map.get("category"));
		return "/customer/notice";
	}
	
	@RequestMapping("/noticeView")
	public String noticeView(int bno,Model model,@RequestParam(defaultValue = "1")int page,String category, String sWord) {
	//	System.out.println(bno);
		HashMap<String,Object> map = bservice.selectOne(bno,sWord,page,category);
		model.addAttribute("board", map.get("board"));
		model.addAttribute("prev", map.get("prev"));
		model.addAttribute("next", map.get("next"));
		model.addAttribute("sWord", sWord);
		model.addAttribute("page", page);
		model.addAttribute("category", category);
		return "/customer/notice_view";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/customer/write";
	}
	
	@PostMapping("/write")
	public String dowrite(@RequestPart MultipartFile file, Board b) {
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
		bservice.insertBoard(b);
		return "redirect:/board/notice";
	}
	
	@RequestMapping("/delete")
	public String delete(int bno) {
		bservice.deleteBoard(bno);
		return "redirect:/board/notice";
	}
	
	@GetMapping("/modi")
	public String modi(int bno,Model model,@RequestParam(defaultValue = "1")int page,String category, String sWord) {
		Board b = bservice.modiBaord(bno);
		model.addAttribute("board", b);
		model.addAttribute("page", page);
		model.addAttribute("category", category);
		model.addAttribute("sWord", sWord);
		return "customer/modi";
	}
	
	@PostMapping("/modi")
		public String modi (Board b, @RequestPart MultipartFile file) {
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
				b.setBfile(fileName); // write일땐 트라이 밖에 modi일땐 안에
			} catch(Exception e) {e.printStackTrace();}
		}
			bservice.updateBoard(b);
			return "redirect:/board/notice";
		}
	
	@GetMapping("/reply")
	public String reply (int bno, Model model) {
		System.out.println(bno);
		Board b = bservice.replyBoard(bno);
		b.setBtop(3);
		model.addAttribute("board", b);
		return "/customer/reply";
	}
	
	@PostMapping("/reply")
	public String doreply () {
		
		return "redirect:/board/notice";
	}
	
}

