package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public ArrayList<Board> selectAll() {
		ArrayList<Board> list = boardMapper.selectAll();
		return list;
	}

	@Override
	public Board selectOne(int bno) {
		Board b = boardMapper.selectOne(bno);
		return b;
	}

}
