package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;

@Mapper
public interface BMapper {
	// 게시글 전체 가져옿기
	ArrayList<Board> selectAll(int startRow, int endRow, String category, String sWord);
	// 게시글 하나 가져오기
	Board selectOne(int bno);

	Board selectPrev(int bno, String category, String sWord);

	Board selectnext(int bno, String category, String sWord);

	int selectListCount(String category, String sWord);

}