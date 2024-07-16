package com.java.service;

import java.util.ArrayList;

import com.java.dto.Board;

public interface BoardService {

	ArrayList<Board> selectAll();

	Board selectOne(int bno);
	
}
