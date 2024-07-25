package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.java.dto.Comment;

public interface BService {

	HashMap<String, Object> selectAll(int page, String category, String sWord);

	HashMap<String, Object> selectOne(int bno, String category, String sWord);

	Comment commentInsert(Comment c);

	ArrayList<Comment> selectComAll(int bno);

	void deletOneCom(int cno);

	Comment modiOneCom(Comment c);

}
