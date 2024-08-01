package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.mapper.MMapper;

@Service
public  class MServiceImpl implements MService {
	
	@Autowired MMapper mMapper;
	

	@Override
	public Member selectLogin(String id, String pw) {
		Member m = mMapper.selectLogin(id, pw);
		return m;
	}


	@Override
	public String selectId(String name, String email) {
		String uid = mMapper.selectId(name,email);
		System.out.println(uid);
		System.out.println(name);
		System.out.println(email);
		return uid;
	}

	
	
}
