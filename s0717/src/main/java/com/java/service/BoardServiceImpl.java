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
	public ArrayList<Board> selectBoardAll() {
		ArrayList<Board> list = boardMapper.selectBoardAll();
		return list;
	}

	@Override
	public Board selectOneBoard(int bno) {
		Board b = boardMapper.selectOneBoard(bno);
		
		return b;
	}

	@Override
	public void insertOne(Board board) {
		boardMapper.insertOne(board);
		
	}

	@Override
	public void updateOne(Board board) {
		boardMapper.updateOne(board);
		
	}

	@Override
	public void deleteOne(int bno) {
		boardMapper.deleteOne(bno);
		
	}

	@Override
	public void updateBhitUp(int bno) {
		boardMapper.updateBhitUp(bno);
		
	}

}
