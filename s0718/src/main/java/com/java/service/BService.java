package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.java.dto.Board;

public interface BService {

	HashMap<String, Object> selectAll(int page);

	Board selectOne(int bno);

	void bhitUp(int bno);

	void insertOne(Board b);

	void modiOne(Board b);

	void deleteOne(int bno);

	void insertReplyOne(Board b);

}
