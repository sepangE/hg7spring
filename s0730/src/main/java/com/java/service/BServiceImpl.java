package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.mapper.BMapper;

@Service
public class BServiceImpl implements BService {

	@Autowired
	BMapper bMapper;
	
	@Override
	public ArrayList<Board> selectAll() {
		ArrayList<Board> list = bMapper.selectAll();
		return list;
	}

	@Override
	public void insertOne(Board b) {
		bMapper.insertOne(b);
		
	}

	@Override
	public Board selectOne(int bno) {
		Board b = bMapper.selectOne(bno);
		return b;
	}

}
