package com.java.service;

import java.util.ArrayList;

import com.java.dto.Member;

public interface MemberService {

	Member selectLogin(String id, String pw);

	ArrayList<Member> selectAll();

	void insertOne(Member m);

	Member selectOne(String id);

	void modiMem(Member m);

	void deleteM(String id);

}
