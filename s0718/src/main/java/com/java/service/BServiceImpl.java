package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired
	BoardMapper bMapper;

	@Override
	public HashMap<String, Object> selectAll(int page) {
		HashMap<String, Object> map = new HashMap<>();
		//1. 전체 게시물 수 
		int listCount = bMapper.selectListCount();
		System.out.println("게시물 수 :" + listCount);
		//2. 최대 페이지
		int maxPage = (int)Math.ceil(listCount/10.0);
		System.out.println("최대 페이지 수 "+maxPage);
		// 시작, 끝페이지
		int startPage = (int)((page-1)/10)*10+1;
		int endPage = startPage+10-1;
		// page에 11이 넘어와야 스타트 페이지가 바뀜
		System.out.println("startPage : "+startPage);
		System.out.println("endPage : "+endPage);
		// 첫 게시물, 마지막 게시물 (한 페이지에 보여질 게시물 수)
		int startRow = (page-1)*10+1;
		int endRow = startRow+10-1;
		System.out.println("startRow : "+startRow);
		System.out.println("endRow : "+endRow);
		//내가 가진 페이지까지만 노출
		if(endPage>maxPage) endPage = maxPage;
		ArrayList<Board> list = bMapper.selectAll(startRow, endRow);
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("page", page);
		map.put("list", list);
		return map;
	}

	@Override
	public Board selectOne(int bno) {
		Board b = bMapper.selectOne(bno);
		return b;
	}

	@Override
	public void bhitUp(int bno) {
		bMapper.bhitUp(bno);
		
	}

	@Override
	public void insertOne(Board b) {
		bMapper.insertOne(b);
		
	}

	@Override
	public void modiOne(Board b) {
		bMapper.modiOne(b);
		
	}

	@Override
	public void deleteOne(int bno) {
		bMapper.deleteOne(bno);
		
	}

	@Override
	public void insertReplyOne(Board b) {
		// 답글 게시글 추가
		bMapper.insertReplyOne(b);
		// bstep 조정
		bMapper.updateBstepCount(b);
		
	}
	
	
	
	
	
	
}
