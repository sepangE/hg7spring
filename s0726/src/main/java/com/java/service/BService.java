package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.java.dto.Board;
import com.java.dto.Cboard;

public interface BService {

	HashMap<String, Object> selectAll(String category, String sWord, int page);

	HashMap<String,Object> selectOne(int bno, String category, String sWord, int page);

	Cboard insertReply(Cboard comm);

	void delOneReply(int cno);

	Cboard updateComm(Cboard comm);

}
