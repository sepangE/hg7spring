package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.mapper.MMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class MServiceImpl implements MService {

	@Autowired MMapper mMapper;
	@Autowired HttpSession session;
	
	@Override
	public Member selectLogin(String id, String pw) {
		Member member = mMapper.selectLogin(id, pw);
		if(member != null) {
			session.setAttribute("sessionId", member.getId());
			session.setAttribute("sessionName", member.getName());
		}
		return member;
	}

	@Override
	public Member searchId(String name, String phone) {
		Member m = mMapper.searchId(name, phone);
		return m;
	}

}
