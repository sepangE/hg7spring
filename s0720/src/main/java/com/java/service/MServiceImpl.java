package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.mapper.MMapper;

@Service
public class MServiceImpl implements MService {
	
	@Autowired
	MMapper mMapper;

	@Override
	public Member selectLogin(Member m) {
		Member mem = mMapper.selectLogin(m);
		return mem;
	}

}
