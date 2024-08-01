package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;

@Mapper
public interface BMapper {

	ArrayList<Board> selectNotice();

	ArrayList<Board> selectEvent();

	void insertOne(Board b);

	ArrayList<Board> selectAll();

}
