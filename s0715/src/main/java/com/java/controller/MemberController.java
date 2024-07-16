package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	// session
	@Autowired
	HttpSession session;
	
	// 파일의 위치
		@RequestMapping("/member1")
		public String member1() {
			// 리턴 주소
			return "member/member1";
		}
		@RequestMapping("/login")
		public String login() {
			// 리턴 주소
			return "member/login";
		}
		// 회원가입창을 보여줌
		@RequestMapping("/memberForm")
		public String memberForm() {
			// 리턴 주소
			return "member/memberForm";
		}
		// 회원가입창에서 전송버튼 눌렀을때 이동
		@RequestMapping("/doMemberForm")
		public String doMemberForm(MemberDto mdto,HttpServletRequest request, Model model) {
//			String id = request.getParameter("id");
//			String pw = request.getParameter("pw");
//			String name = request.getParameter("name");
//			String gender = request.getParameter("gender");
//			System.out.println(id+pw+name+gender);
			
//			MemberDto member = new MemberDto(id,pw,name,gender);
			
			model.addAttribute("member", mdto);
			
//			model.addAttribute("id", id);
//			model.addAttribute("pw", pw);
//			model.addAttribute("name", name);
//			model.addAttribute("gender", gender);
			return "member/doMemberForm";
		}
		
//		@RequestMapping("/doLogin")
//		public String doLogin(@RequestParam(defaultValue="admin") String id, @RequestParam("pw") String pw, Model model) {
//			model.addAttribute("id", id);
//			model.addAttribute("pw", pw);
//			// 리턴 주소
//			return "member/doLogin";
//		}
		@RequestMapping("/doLogin")
		public String doLogin(String id, String pw, Model model) {
			System.out.println("아이디 : "+id);
			System.out.println("비밀번호 : "+pw);
			
			//HttpSession session = request.getSession(); 대신에
			// iv에 autowried로 HttpSession session 선언하기
			
			// 만약 db에 aaa 1111이라면
			if(id.equals("aaa") && pw.equals("1111")) {
				session.setAttribute("sessionId", id);
			}
			return "member/doLogin";
		} // doLogin
		
		@RequestMapping("/mForm")
		public String mForm() {
			return "member/mForm";
		}
		@RequestMapping("/doMForm")
		public String doMForm(MemberDto mdto, String[] hobbys, Model model) {
			// 확인용
			//System.out.println(mdto.getName());
			String hobby = "";
			for(int i =0; i < hobbys.length; i++) {
				if(i==0) hobby += hobbys[i];
				else hobby += ", " + hobbys[i];
			}
			mdto.setHobby(hobby);
			model.addAttribute("member", mdto);
			// 리턴 주소
			return "member/doMForm";
		}// doMForm
		
		@RequestMapping("/updatemForm")
		public String updatemForm(MemberDto mdto,Model model) {
			model.addAttribute("member", mdto);
			
			return "member/updatemForm";
		}
		
		
		
		
}
