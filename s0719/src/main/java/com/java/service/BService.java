package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.java.dto.Board;

public interface BService {

	HashMap<String, Object> selectAll(int page);

	void bhitUp(int bno);

	Board selectOne(int bno);

	void deleteOne(int bno);

	void insertOne(Board b);

	void modiOne(Board b);

	void replyOne(Board b);

}
