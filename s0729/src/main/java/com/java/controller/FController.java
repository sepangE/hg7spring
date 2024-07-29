package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FController {
	
	@RequestMapping("/")
	public String index() {
		return "/index";
	}
	
	@RequestMapping("/blist")
	public String blist() {
		return "/blist";
	}
	
	@RequestMapping("/bikeData")
	public String bikeData() {
		return "/bikeData";
	}
	
	@RequestMapping("/sportsData")
	public String sportsData() {
		return "/sportsData";
	}
	
	@RequestMapping("/subwayData")
	public String subwayData() {
		return "/subwayData";
	}
	
	@RequestMapping("/movieData")
	public String movieData() {
		return "/movieData";
	}
	
	@RequestMapping("/publicData")
	public String publicData() {
		return "/publicData";
	}
	
	
}
