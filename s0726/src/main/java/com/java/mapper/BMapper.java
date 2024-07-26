package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;
import com.java.dto.Cboard;

@Mapper
public interface BMapper {

	ArrayList<Board> selectAll(int startRow, int endRow, String category, String sWord);

	Board selectOne(int bno, String category, String sWord);

	int selectListCount(String category, String sWord);

	void bhitUp(int bno);

	Board selectPrev(int bno, String category, String sWord);

	Board selectNext(int bno, String category, String sWord);

	ArrayList<Cboard> selectAllReply(int bno);

	void insertReply(Cboard comm);

	Cboard selectOneReply(Cboard comm);

	void delOneReply(int cno);

	void updateComm(Cboard comm);

}
