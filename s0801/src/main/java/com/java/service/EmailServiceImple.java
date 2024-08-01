package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImple implements EmailService {

	@Autowired JavaMailSender mailSender;
	
	@Override
	public String sendEmail(String name, String email) {
	//	System.out.println(name + ", " + email);
		String pwcode = createPwCode();
		
		// 단순 이메일 발송
		sendEamil(name,email,pwcode);
		return pwcode;
	}

	private void sendEamil(String name, String email, String pwcode) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setFrom("hphk178@gmail.com");
		message.setSubject("아이디찾기 인증번호 발송");
		message.setText("인증번호\n"+pwcode+"\n 기존 페이지로 가셔서 입력해주세요");
		mailSender.send(message);
		System.out.println("메일 발송 완료");
	}

	private String createPwCode() {
		char[] charset = {'0','1','2','3','4','5','6','7','8','9',
				'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
				'o','p','q','r','s','t','u','v','w','x','y','z'};
		String pwcode ="";
		int idx = 0;
		for(int i = 0; i < 10; i++) {
			idx = (int)(Math.random()*36);
			pwcode += charset[idx];
		}
		return pwcode;
	}

}
