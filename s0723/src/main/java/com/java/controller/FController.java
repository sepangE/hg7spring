package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FController {
	
	@RequestMapping("/")
	public String index() {
		return "/main";
	} // index
	
	@RequestMapping("/ajax01")
	public String ajax01() {
		return "/ajax01";
	} // ajax01
	
	@RequestMapping("/ajax02")
	public String ajax02() {
		return "/ajax02";
	} // ajax02
	
	
	
}
