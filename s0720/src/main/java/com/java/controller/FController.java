package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Member;
import com.java.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired
	MService mservice;
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	@PostMapping("/login")
	public String dologin(Member m, Model model) {
		System.out.println("아이디 : "+m.getId());
		Member mem = mservice.selectLogin(m);
		
		if(mem != null) {
			session.setAttribute("sessionId", mem.getId());
			session.setAttribute("sessionName", mem.getName());
			model.addAttribute("loginCk", 1);
		} else {
			model.addAttribute("loginCk", 0);
		}
			
		return "/login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "/index";
	}
	
}
