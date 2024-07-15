package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;
import com.java.service.BServiceImpl2;

@Controller
public class FContoller {
	@Autowired 
	// 생성할 객체 클래스에 @Component 있어야함
	// 객체를 생성하지 않아도 사용할 수 있게 해줌 : DI라고 함
	// 스프링은 내가 객체를 선언하지 않아도 스프링이 해준다
	BoardDto bdto;
	// 다형성
//	BService bservice = new BServiceImpl();
//	BService bservice2 = new BServiceImpl2();
	BServiceImpl bservice1 = new BServiceImpl();
	BServiceImpl2 bservice2 = new BServiceImpl2();
	@Autowired 
	// @Service가 붙은 위치에 적용이 됨
	// 서비스는 인터페이스 상속받는 애들중에 하나만 적용이 됨 
	// 여러개 입력하면 오류
	BService bservice;
	
	@RequestMapping("/index")
	public String index() {
		bdto.setBno(1);
		System.out.println(bdto.getBno());
		System.out.println(bservice1.add());
		System.out.println(bservice2.add());
		System.out.println(bservice.add());
		return "index";
	}
	
}
