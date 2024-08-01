package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FController {
	
	@RequestMapping("/")
	public String index() {
		return "/layout/main";
	}
	
	@RequestMapping("/layout/main")
	public String main() {
		return "/layout/main";
	}
	
}
