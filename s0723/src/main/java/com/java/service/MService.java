package com.java.service;

import java.util.ArrayList;

import com.java.dto.Member;

public interface MService {

	ArrayList<Member> memberSelectAll();

	int login(Member m);

	Member insertOne(Member m);

	void delOneMem(String id);

}
