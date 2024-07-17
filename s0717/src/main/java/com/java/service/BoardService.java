package com.java.service;

import java.util.ArrayList;

import com.java.dto.Board;

public interface BoardService {

	ArrayList<Board> selectBoardAll();

	Board selectOneBoard(int bno);

	void insertOne(Board board);

	void updateOne(Board board);

	void deleteOne(int bno);

	void updateBhitUp(int bno);

}
