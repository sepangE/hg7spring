package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.mapper.MMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class MServiceImpl implements MService {

	@Autowired
	MMapper mMapper;
	@Autowired
	HttpSession session;
	
	@Override
	public ArrayList<Member> memberSelectAll() {
		ArrayList<Member> list = mMapper.memberSelectAll();
		return list;
	}
	@Override
	public int login(Member m) {
		int result = 0;
		Member mem = mMapper.login(m);
		// 로그인 성공시
		if(mem!=null) {
			result = 1;
			session.setAttribute("sessionId", mem.getId());
			session.setAttribute("sessionName", mem.getName());
		}
		return result;
	}
	@Override
	public Member insertOne(Member m) {
		mMapper.insertOne(m);
		Member member = mMapper.selectOne(m);
		System.out.println("잘 가져왔니"+member.getHobbys());	
		return member;
	}
	@Override
	public void delOneMem(String id) {
		mMapper.delOneMem(id);
		
	}

}
