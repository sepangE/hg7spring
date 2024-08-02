package com.java.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
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


	@Override
	public String idck(String id) {
		String idCk = mMapper.idck(id);
		return idCk;
	}


	@Override
	public void insertJoin(Member mem) {
		System.out.println("insertJoin");
		String phone = mem.getPhone1() + mem.getPhone2() + mem.getPhone3();
		String email = mem.getMailId() +"@"+ mem.getMailTail();
		String addr = mem.getZip() + mem.getAddr1() + mem.getAddr2();
		String bday = mem.getYear() +"-"+ mem.getMonth() +"-"+ mem.getDay()+" 00:00:00";
		System.out.println(bday);
		Timestamp bdate = Timestamp.valueOf(bday);
		System.out.println(bdate);
		mem.setPhone(phone);
		mem.setEmail(email);
		mem.setAddr(addr);
		mem.setBdate(bdate);
		
		mMapper.insertJoin(mem);
	}


	@Override
	public Member selectOne(String id) {
		Member mem = mMapper.selectOne(id);
		return mem;
	}


	@Override
	public void modiMem(Member mem) {
		String phone = mem.getPhone1() + mem.getPhone2() + mem.getPhone3();
		String email = mem.getMailId() +"@"+ mem.getMailTail();
		String addr = mem.getZip() + mem.getAddr1() + mem.getAddr2();
		String bday = mem.getYear() +"-"+ mem.getMonth() +"-"+ mem.getDay()+" 00:00:00";
		System.out.println(bday);
		Timestamp bdate = Timestamp.valueOf(bday);
		System.out.println(bdate);
		System.out.println(mem.getPw());
		System.out.println(mem.getId());
		mem.setPhone(phone);
		mem.setEmail(email);
		mem.setAddr(addr);
		mem.setBdate(bdate);
		mMapper.modiMem(mem);
	}

	
	
}
