package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Member;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MController {
	
	@Autowired
	MemberService memberService;

	@Autowired
	HttpSession session;
	
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}// login
	
	@RequestMapping("/doLogin")
	public String doLogin(String id, String pw, Model model) {
		System.out.println(id);
		System.out.println(pw);
		
		Member m = memberService.selectLogin(id,pw);
		
		if(m!=null) {
			session.setAttribute("sessionId", m.getId());
			session.setAttribute("sessionName", m.getName());
			model.addAttribute("loginCheck", 1);
		} else {
			model.addAttribute("loginCheck", 0);
		}
		return "member/doLogin";
	} // doLogin
	
	@RequestMapping("/logout")
	public String logout(Model model) {
		session.invalidate();
		model.addAttribute("logout", 1);
		return "member/logout";
	} // logout
	
	@RequestMapping("/join")
	public String join() {
		return "member/join";
	} // join
	
	@RequestMapping("/doJoin")
	public String doJoin(Member m, String[] hobby, Model model) {
		System.out.println(m.getId());
		System.out.println(m.getName());
		System.out.println(m.getGender());
		String hobbys = "";
		for(int i = 0; i < hobby.length; i++) {
			if(i==0) hobbys += hobby[i];
			else hobbys += ", " + hobby[i];
		}
		m.setHobbys(hobbys);
		model.addAttribute("member", m);
		return "member/doJoin";
	} // doJoin
	
	@RequestMapping("/memList")
	public String memList(Model model) {
		
		ArrayList<Member> list = memberService.memberSelectAll();
		// 확인용
		System.out.println(list.get(0).getName());
		
		model.addAttribute("list", list);
		return "member/memList";
	}// memList
	
	@RequestMapping("/memView")
	public String memView(String id, Model model) {
		System.out.println("id : "+id);
		Member m = memberService.memberSelectOne(id);
		model.addAttribute("m", m);
		return "member/memView";
	}// memView
	
	
	
} // MController
