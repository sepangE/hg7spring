package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Member;

@Mapper
public interface MemberMapper {

	Member selectLogin(String id, String pw);

	ArrayList<Member> selectAll();

	void insertOne(Member m);

	Member selectOne(String id);

	void modiMem(Member m);

	void deleteM(String id);

}
