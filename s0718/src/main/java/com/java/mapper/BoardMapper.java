package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;

@Mapper
public interface BoardMapper {

	ArrayList<Board> selectAll(int startRow, int endRow);

	Board selectOne(int bno);

	void bhitUp(int bno);

	void insertOne(Board b);

	void modiOne(Board b);

	void deleteOne(int bno);

	void insertReplyOne(Board b);

	void updateBstepCount(Board b);

	int selectListCount();

}
