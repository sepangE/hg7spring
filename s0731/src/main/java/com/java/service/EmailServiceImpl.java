package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired JavaMailSender mailSender;
	
	@Override
	public String getCode(String name, String email) {
		
		System.out.println("이름 : "+name);
		System.out.println("이메일 : "+email);
		
		// 1. 임시 비밀번호 생성
		String pwcode = createPwCode();
		System.out.println("생성된 임시코드 : " + pwcode);
		
		// 2. 이메일 발송하기
		// 2-1 단순 이메일 발송
		//sendEmail(name,email,pwcode);
		// html 이메일 발송
		sendHtmlEamil(name,email,pwcode);
		
		return pwcode;
	}
	private void sendHtmlEamil(String name, String email, String pwcode) {
		MimeMessage message = mailSender.createMimeMessage();
		String htmltxt="";
		try {
			message.setSubject("[안내]"+name+"님 이메일 인증 임시번호를 발송합니다.");
			htmltxt += htmlTxt(name,pwcode);
			message.setText(htmltxt,"utf-8","html");
			message.addRecipient(RecipientType.TO, new InternetAddress(email));
			message.setFrom(new InternetAddress("hphk178@gmail.com"));
			mailSender.send(message);
			System.out.println("메일이 발송되었습니다.");
		} catch(Exception e) {e.printStackTrace();}
		
	}
	// 단순 이메일 발송하는 메서드
	public void sendEmail(String name, String email, String pwcode) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email); // -에게
		message.setFrom("hphk178@gmail.com"); // -로부터
		message.setSubject(name+"님에게 이메일 인증 임시번호 발송합니다."); // 제목
		message.setText("안녕하세요 아이디를 찾기 위한 임시번호를 안내해드립니다.\n"+
			"["+name+"]님의 임시번호 : "+ pwcode +"]\n" );
		mailSender.send(message);
		System.out.println("메일이 발송되었습니다.");
		
	}
	// 임시번호를 생성하는 메서드
	public String createPwCode() {
		char[] charset = {'0','1','2','3','4','5','6','7','8','9',
				'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
				'o','p','q','r','s','t','u','v','w','x','y','z'};
		String pwcode="";
		int idx = 0;
		
		for(int i = 0; i < 10; i++) {
			idx = (int)(Math.random()*36);
			pwcode += charset[idx];
		}
		return pwcode;
	}
	
	public String htmlTxt(String name, String pwcode) {
		String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
				+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"ko\" xml:lang=\"ko\">\r\n"
				+ "<head>\r\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"application/xhtml+xml; charset=utf-8\" />\r\n"
				+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "<title> 임시코드 발송 </title>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</head>\r\n"
				+ "<body bgcolor=\"#FFFFFF\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\" style=\"margin:0; padding:0; font:normal 12px/1.5 돋움;\">\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "<table width=\"700\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\r\n"
				+ "<tr>\r\n"
				+ "	<td style=\"width:700px;height:175px;padding:0;margin:0;vertical-align:top;font-size:0;line-height:0;\">\r\n"
				+ "		<img src=\"../images/email/img_email_top.jpg\" alt=\"JARDIN\" />					\r\n"
				+ "	</td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "	<td style=\"width:700px;height:78px;padding:0;margin:0;vertical-align:top;\">\r\n"
				+ "		<p style=\"width:620px;margin:50px 0 40px 38px;text-align:center;font-size:0;line-height:0;\"><img src=\"../images/email/img_txt_id01.jpg\" alt=\"원두커피의 名家, JARDIN 문의하신 회원님 ID를 발송해 드립니다.\" /></p>\r\n"
				+ "	</td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "	<td style=\"width:700px;height:179px;padding:0;margin:0;vertical-align:top;\">\r\n"
				+ "		<table width=\"618\" height=\"177\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" style=\"margin:0 0 0 40px;border:1px #d9d9d9 solid;\">\r\n"
				+ "		<tr>\r\n"
				+ "			<td style=\"width:618px;height:177px;padding:0;margin:0;vertical-align:top;font-size:0;line-height:0;background:#f9f9f9;\">\r\n"
				+ "				<p style=\"width:620px;margin:30px 0 0 0;padding:0;text-align:center;\"><img src=\"../images/email/img_txt_id02.jpg\" alt=\"쟈뎅샵에서 ID찾기를 요청하셨습니다.\" /></p>\r\n"
				+ "				<p style=\"width:620px;margin:30px 0 0 0;padding:0;text-align:center;color:#666666;font-size:12px;line-height:1;\"><strong>임시코드 : <span style=\"color:#f7703c;line-height:1;\">"
				+ pwcode
				+ "</span></strong></p>\r\n"
				+ "				<p style=\"width:620px;margin:30px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1.4;\">쟈뎅샵에서는 고객님께 보다 나은 서비스를 제공하기 위해 항상 노력하고 있습니다.<br/>앞으로 많은 관심 부탁드립니다.</p>\r\n"
				+ "			</td>\r\n"
				+ "		</tr>\r\n"
				+ "		</table>	\r\n"
				+ "	</td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "	<td style=\"width:700px;height:120px;padding:0;margin:0;vertical-align:top;\">\r\n"
				+ "		<p style=\"width:700px;margin:30px 0 50px 0;text-align:center;\"><a href=\"#\"><img src=\"../images/email/btn_jardin.jpg\" alt=\"JARDIN 바로가기\" /></a></p>\r\n"
				+ "	</td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "	<td style=\"width:700px;height:50px;padding:0;vertical-align:top;font-size:0;line-height:0;text-align:center;\">\r\n"
				+ "		<img src=\"../images/email/img_email_bottom.jpg\" alt=\"\" />\r\n"
				+ "	</td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "	<td style=\"width:700px;height:140px;padding:0;margin:0;vertical-align:top;background-color:#5a524c;\">\r\n"
				+ "		<p style=\"width:620px;margin:20px 0 0 40px;padding:0;text-align:center;line-height:1.5;color:#b2aeac;\">메일수신을 원치 않으시는 분은 로그인 후. <span style=\"color:#ffffff\">메일 수신 여부</span>를 변경해주시기 바랍니다.<br/>IF YOU DO NOT WISH TO RECEIVE EMAILS FROM US, PLEASE LOG-IN AND UPDATE<br/> YOUR MEMBERSHIP INFORMATION.</p>\r\n"
				+ "\r\n"
				+ "		<p style=\"width:620px;margin:15px 0 0 40px;padding:0;text-align:center;line-height:1.5;color:#b2aeac;\"><span style=\"color:#ffffff\">본 메일에 관한 문의사항은 사이트 내 고객센터를 이용해주시기 바랍니다.</span><br/>COPYRIGHT ©  2014 JARDIN ALL RIGHTS RESERVED.</p>\r\n"
				+ "	</td>\r\n"
				+ "</tr>\r\n"
				+ "</table>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		return html;
	} // htmlTxt
}
