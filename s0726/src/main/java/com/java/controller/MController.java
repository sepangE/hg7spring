package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Member;
import com.java.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MController {
	
	@Autowired MService mservice;
	@Autowired HttpSession session;
	
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/loginB")
	@ResponseBody
	public Member dologin(String id, String pw) {
	//	System.out.println("MController - id"+id);
	//	System.out.println("MController - pw"+pw);
		Member member = mservice.selectLogin(id, pw);
		return member;
	}
	
	@RequestMapping("logout")
	public String logout() {
		session.invalidate();
		return "/main";
	}
	
	@GetMapping("/idsearch")
	public String idsearch() {
		return "/member/idsearch";
	}
	
	@PostMapping("/idsearch")
	@ResponseBody
	public Member doidsearch(String name, String phone) {
		Member member = mservice.searchId(name, phone);
		System.out.println(member.getId());
		return member;
	}
	
	
}
