package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FController {
	
	@RequestMapping("/")
	public String index() {
		return "/index";
	}
	
	@RequestMapping("/checkbox")
	public String checkbox() {
		return "/checkbox";
	}
	
	@RequestMapping("/inputCheck")
	public String inputCheck() {
		return "/inputCheck";
	}
	
	@RequestMapping("/sendEmail")
	public String sendEmail() {
		return "/sendEmail";
	}
	
}
