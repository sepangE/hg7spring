package com.java.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Member;

@Mapper
public interface MMapper {

	Member selectLogin(String id, String pw);

	String selectId(String name, String email);

	String idck(String id);

	void insertJoin(Member mem);

	Member selectOne(String id);

	void modiMem(Member mem);

}
