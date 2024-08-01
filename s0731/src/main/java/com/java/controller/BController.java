package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.Board;
import com.java.service.BService;

@Controller
@RequestMapping("/board")
public class BController {
	
	@Autowired BService bservice;
	
	@RequestMapping("/notice")
	public String notice(Model model) {
		ArrayList<Board> list = bservice.selectNotice();
		model.addAttribute("list", list);
		return "/board/notice";
	}
	
	@RequestMapping("/event")
	public String event(Model model) {
		ArrayList<Board> list = bservice.selectEvent();
		model.addAttribute("list", list);
		return "/board/event";
	}
	
	@RequestMapping("/product")
	public String product(Model model) {
		ArrayList<Board> list = bservice.selectAll();
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/board/write";
	}
	
	@PostMapping("/write")
	public String dowrite(Board b, @RequestPart MultipartFile file) {
	//	System.out.println(b.getBtop());
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
		b.setId("admin");
		bservice.insertOne(b);
		if(b.getBtop()==1) {
			return "redirect:/board/notice";
		}else if(b.getBtop()==2){
			return "redirect:/board/event";
		} else {
			return "redirect:/";
		}
	}
	
	
}
