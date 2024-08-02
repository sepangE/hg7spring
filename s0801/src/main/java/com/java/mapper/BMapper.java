package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;

@Mapper
public interface BMapper {

	ArrayList<Board> selectAll(String category, String sWord, int startRow, int endRow);

	int selectListCount(String category, String sWord);

	Board selectOne(int bno);

	void bhitUp(int bno);

	Board selectPrev(int bno, String sWord, String category);

	Board selectNext(int bno, String sWord, String category);

	void insertBoard(Board b);

	void deleteBoard(int bno);

	void updateBoard(Board b);

}
