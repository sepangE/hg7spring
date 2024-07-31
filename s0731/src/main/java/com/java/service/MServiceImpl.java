package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mapper.MMapper;

@Service
public class MServiceImpl implements MService {

	@Autowired MMapper mMapper;

	@Override
	public String idck(String userId) {
		String idCk= mMapper.idck(userId);
		return idCk;
	}
	
}
