package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Board;
import com.java.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/bList")
	public String bList(Model model) {
		ArrayList<Board> list = boardService.selectAll();
		model.addAttribute("list", list);
		return "/board/bList";
	} // bList
	
	@RequestMapping("/bView")
	public String bView(int bno, Model model) {
		Board b = boardService.selectOne(bno);
	//	System.out.println(b.getBtitle());
		model.addAttribute("b", b);
		return "board/bView";
	}
	
	
}
