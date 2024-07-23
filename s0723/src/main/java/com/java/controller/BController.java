package com.java.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.Board;
import com.java.service.BService;

@Controller
@RequestMapping("/board")
public class BController {
	
	@Autowired
	BService bservice;
	
	@RequestMapping("/notice")
	public String notice(Model model, String category, String sWord,@RequestParam(defaultValue="1")int page) {
		HashMap<String,Object> map = bservice.selectAll(page, category, sWord);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("listCount", map.get("listCount"));
		model.addAttribute("maxPage", map.get("maxPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("startRow", map.get("startRow"));
		model.addAttribute("endRow", map.get("endRow"));
		model.addAttribute("category", map.get("category"));
		model.addAttribute("sWord", map.get("sWord"));
		model.addAttribute("page", map.get("page"));
		
		return "board/notice";
	}
	
	@RequestMapping("/noticeView")
	public String noticeView(int bno, Model model,String category, 
			String sWord,@RequestParam(defaultValue="1")int page) {
	//	System.out.println(bno);
		HashMap<String, Object> map = bservice.selectOne(bno,category,sWord);
		Board board = (Board) map.get("board");
	//	System.out.println(board.getBtitle());
		model.addAttribute("board", board);
		// 이전 게시글
		model.addAttribute("prev", map.get("prev"));
		// 이후 게시글
		model.addAttribute("next", map.get("next"));
		model.addAttribute("category", category);
		model.addAttribute("sWord", sWord);
		model.addAttribute("page", page);
		return "board/noticeView";
	}
	
}
