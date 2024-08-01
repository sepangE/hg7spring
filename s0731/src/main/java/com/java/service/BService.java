package com.java.service;

import java.util.ArrayList;

import com.java.dto.Board;

public interface BService {

	ArrayList<Board> selectNotice();

	ArrayList<Board> selectEvent();

	void insertOne(Board b);

	ArrayList<Board> selectAll();

}
