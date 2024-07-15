package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	// 파일의 위치
		@RequestMapping("/board/board1")
		public String board1() {
			// 주소
			return "board/board1";
		}
}
