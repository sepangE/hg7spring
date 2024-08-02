package com.java.service;

import com.java.dto.Member;

public interface MService {

	Member selectLogin(String id, String pw);

	String selectId(String name, String email);

	String idck(String id);

	void insertJoin(Member mem);

	Member selectOne(String id);

	void modiMem(Member mem);


}
