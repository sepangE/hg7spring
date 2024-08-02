package com.java.service;

import java.util.HashMap;

import com.java.dto.Board;

public interface BService {

	HashMap<String, Object> selectAll(int page, String category, String sWord);

	HashMap<String, Object> selectOne(int bno, String sWord, int page, String category);

	void insertBoard(Board b);

	void deleteBoard(int bno);

	Board modiBaord(int bno);

	void updateBoard(Board b);

	Board replyBoard(int bno);

}
