package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.EmailService;


@Controller
@RequestMapping("/email")
public class EmailController {
	
	@Autowired EmailService eservice;
	
	@PostMapping("/emailSend")
	@ResponseBody
	public String emailSend(String name, String email) {
		String pwCode = eservice.getCode(name,email);
		return "pwCode";
	}
	
}
