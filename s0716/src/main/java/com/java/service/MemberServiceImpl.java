package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;
	@Override
	public ArrayList<Member> memberSelectAll() {
		
		ArrayList<Member> list = memberMapper.memberSelectAll();
		return list;
	}//memberSelectAll()
	
	@Override
	public Member memberSelectOne(String id) {
		Member m = memberMapper.memberSelectOne(id);
		
		return m;
	}// memberSelectOne
	
	@Override
	public Member selectLogin(String id, String pw) {
		Member m = memberMapper.memberSelectLogin(id,pw);
		return m;
	}

	
	
	
	
}
