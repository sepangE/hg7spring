package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Member;
import com.java.service.MService;

@Controller
@RequestMapping("/member")
public class MContoller {
	
	@Autowired MService mservice;
	
	@RequestMapping("/idCk")
	@ResponseBody
	public String idCk(String userId) {
		String idCk = mservice.idck(userId);
		return idCk;
	}
	
	@RequestMapping("/step02")
	public String step02() {
		return "/member/step02";
	}
	
	@RequestMapping("/step03")
	public String step03() {
		return "/member/step03";
	}
	
	@RequestMapping("/idsearch")
	public String idsearch() {
		return "/member/idsearch";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	@RequestMapping("/join")
	@ResponseBody
	public String join(Member m) {
		System.out.println(m.getName());
		return "성공";
	}
	
	
	
}
