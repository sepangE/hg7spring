package com.java.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Cboard;
import com.java.service.BService;

@Controller
@RequestMapping("/board")
public class BController {
	
	
	@Autowired BService bservice;
	
	@RequestMapping("/notice")
	public String notice(Model model, @RequestParam(defaultValue = "1")int page,
					String category, String sWord) {
		HashMap<String, Object> map = bservice.selectAll(category,sWord,page);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("listCount", map.get("listCount"));
		model.addAttribute("maxPage", map.get("maxPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("startRow", map.get("startRow"));
		model.addAttribute("endRow", map.get("endRow"));
		model.addAttribute("page", map.get("page"));
		model.addAttribute("category", map.get("category"));
		model.addAttribute("sWord", map.get("sWord"));
		return "/board/notice";
	}
	
	@RequestMapping("/noticeView")
	public String noticeView(int bno,Model model, @RequestParam(defaultValue = "1")int page,
				String category, String sWord ) {
		System.out.println("bcontroller");
		System.out.println(sWord);
		System.out.println(category);
		HashMap<String,Object> map = bservice.selectOne(bno,category,sWord,page);
		
		
		
		model.addAttribute("board", map.get("board"));
		model.addAttribute("prev", map.get("prev"));
		model.addAttribute("next", map.get("next"));
		model.addAttribute("page", map.get("page"));
		model.addAttribute("category", map.get("category"));
		model.addAttribute("sWord", map.get("sWord"));
		model.addAttribute("clist", map.get("clist"));
		
		return "/board/noticeView";
	}
	
	@PostMapping("/insertReply")
	@ResponseBody
	public Cboard insertReply(Cboard comm) {
		Cboard comment = bservice.insertReply(comm);
		System.out.println(comment.getCcontent());
		return comment;
	}
	@PostMapping("/delReply")
	@ResponseBody
	public String delReply(int cno) {
		bservice.delOneReply(cno);
		return "성공";
	}
	
	@PostMapping("/modiComm")
	@ResponseBody
	public Cboard modiComm(Cboard comm) {
		Cboard comment = bservice.updateComm(comm);
		return comment;
	}
	
	
	
}
