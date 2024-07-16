package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;

@Mapper
public interface BoardMapper {

	ArrayList<Board> selectAll();

	Board selectOne(int bno);

}
