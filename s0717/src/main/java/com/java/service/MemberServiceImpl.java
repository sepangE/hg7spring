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
	public Member selectLogin(String id, String pw) {
		Member m = memberMapper.selectLogin(id,pw);
		
		return m;
	}

	@Override
	public ArrayList<Member> selectAll() {
		ArrayList<Member> list = memberMapper.selectAll();
		return list;
	}

	@Override
	public void insertOne(Member m) {
		memberMapper.insertOne(m);
		
	}

	@Override
	public Member selectOne(String id) {
		Member m = memberMapper.selectOne(id);
		return m;
	}

	@Override
	public void modiMem(Member m) {
		memberMapper.modiMem(m);
		
	}

	@Override
	public void deleteM(String id) {
		memberMapper.deleteM(id);
		
	}

}
