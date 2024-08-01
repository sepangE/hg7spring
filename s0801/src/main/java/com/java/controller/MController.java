package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Member;
import com.java.service.EmailService;
import com.java.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MController {
	
	@Autowired MService mservice;
	@Autowired HttpSession session;
	@Autowired EmailService emailService;
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String dologin(String id, String pw) {
	//	System.out.println("id : "+id);
	//	System.out.println("pw : "+pw);
		Member member = mservice.selectLogin(id,pw);
		session.setAttribute("sessionId", member.getId());
		session.setAttribute("sessionName", member.getName());
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/step02")
	public String step02() {
		return "/member/step02";
	}
	
	@GetMapping("/idsearch")
	public String idsearch() {
		return "/member/idsearch";
	}
	
	@PostMapping("/idsearch")
	@ResponseBody
	public String doidsearch(String name, String email) {
		System.out.println(name);
		System.out.println(email);
		String pwCode = emailService.sendEmail(name,email);
		System.out.println(pwCode);
		return pwCode;
	}
	
	@PostMapping("/pwCodeCk")
	@ResponseBody
	public String pwCodeCk(String name, String email) {
		String uid=mservice.selectId(name,email);
		System.out.println(uid);
		return uid;
	}
	
	
	
	
	
	
}
