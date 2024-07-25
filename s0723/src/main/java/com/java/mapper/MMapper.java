package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Member;

@Mapper
public interface MMapper {

	ArrayList<Member> memberSelectAll();

	Member login(Member m);

	void insertOne(Member m);

	Member selectOne(Member m);

	void delOneMem(String id);

}
