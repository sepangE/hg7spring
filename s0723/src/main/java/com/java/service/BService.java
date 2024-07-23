package com.java.service;

import java.util.HashMap;

public interface BService {

	HashMap<String, Object> selectAll(int page, String category, String sWord);

	HashMap<String, Object> selectOne(int bno, String category, String sWord);

}
