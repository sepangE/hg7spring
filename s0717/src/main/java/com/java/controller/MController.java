package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Member;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MController {
	
	@Autowired
	MemberService mservice;
	@Autowired
	HttpSession session;
	
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	} // login
	
	@RequestMapping("/dologin")
	public String dologin(String id, String pw, Model model) {
		//System.out.println(id+pw);
		int result = 0;
		Member m = mservice.selectLogin(id,pw);
		System.out.println(m.getName());
		if(m!=null) {
			session.setAttribute("sessionId", m.getId());
			session.setAttribute("sessionName", m.getName());
			result = 1;
		} else {
			result = 0;
		}
		model.addAttribute("result", result);
		
		return "member/dologin";
	} // dologin
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "member/logout";
	} // logout
	
	@GetMapping("/mlist")
	public String mlist(Model model) {
		ArrayList<Member> list = mservice.selectAll();
		//System.out.println(list.get(0).getName());
		model.addAttribute("list", list);
		return "member/mlist";
	} // join
	
	@GetMapping("/join")
	public String join() {
		return "member/join";
	} // join
	
	@PostMapping("/join")
	public String doJoin(Member m, Model model, String[] hobby) {
		String hobbys="";
		for(int i = 0; i < hobby.length; i++) {
			if(i==0) hobbys+=hobby[i];
			else hobbys+=", "+hobby[i];
		}
		m.setHobbys(hobbys);
		mservice.insertOne(m);
		return "redirect:/index";
	} // login
	@GetMapping("/mView")
	public String mView(String id, Model model) {
	//	System.out.println(id);
		Member m = mservice.selectOne(id);
		
		model.addAttribute("m", m);
		return "member/mView";
	} // join
	
	@GetMapping("/modiM")
	public String modiM(String id, Model model) {
		Member m = mservice.selectOne(id);
		model.addAttribute("m", m);
		return "member/modiM";
	}
	
	@PostMapping("/modiM")
	public String doModiM(Member m, String[] hobby) {
		String hobbys="";
		for(int i = 0; i < hobby.length; i++) {
			if(i==0) hobbys+=hobby[i];
			else hobbys+=", "+hobby[i];
		}
		m.setHobbys(hobbys);
		mservice.modiMem(m);
		return "redirect:mlist";
	} // domodiM
	
	
	@RequestMapping("/deleteM")
	public String deleteM(String id) {
		mservice.deleteM(id);		
		
		return "redirect:mlist";
	}
}
