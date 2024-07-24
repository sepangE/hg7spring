package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Member;
import com.java.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MController {
	
	@Autowired MService mservice;
	@Autowired HttpSession session;
	
	@PostMapping("/member/selectAll")
	@ResponseBody // 리턴을 페이지가 아닌 데이터로 돌려줌
	public ArrayList<Member> selectAll() {
		ArrayList<Member> list = mservice.memberSelectAll();
		System.out.println("member select all : "+list.get(0).getId());
		return list;
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
// ================== jsp 형태========================
	@PostMapping("/member/login")
	public String dologin(Member m, Model model) {
		System.out.println("id : "+m.getId());
		System.out.println("pw : "+m.getPw());
		int result= mservice.login(m);
		model.addAttribute("result", result);
		// 1은 성공 2는 실패
		return "redirect:/";
	}
	
// ================== ajax 형태========================
	@PostMapping("/member/ajaxLogin")
	@ResponseBody
	public String ajaxlogin(Member m) {
		System.out.println("id : "+m.getId());
		System.out.println("pw : "+m.getPw());
		// 1은 성공 0은 실패
		int result= mservice.login(m);
		return ""+result;
	}
	
	@RequestMapping("/member/logout")
	public String logout() {
		session.invalidate();
		return "/main";
	}
	
	
	
	
	
}
