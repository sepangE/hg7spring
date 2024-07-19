package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;

@Mapper
public interface BMapper {

	ArrayList<Board> selectAll(int startRow, int endRow);

	void bhitUp(int bno);

	Board selectOne(int bno);

	void deleteOne(int bno);

	void insertOne(Board b);

	void modiOne(Board b);

	void replyOne(Board b);

	void insertReplyOne(Board b);

	void updateBstepCount(Board b);

	int selectlistCount();

}
