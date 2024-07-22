package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.mapper.BMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired
	BMapper bmapper;

	@Override
	public HashMap<String, Object> selectAll(int page, String category, String s_word) {
		System.out.println("bserviceImpl category : "+ category);
		System.out.println("bserviceImpl s_word : "+ s_word);
		
		HashMap<String, Object> map = new HashMap<>();
		
		//1. 전체 게시물 수 
		int listCount = bmapper.selectListCount(category,s_word);
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
		// startrow부터 endrow 까지의 게시글 가져오기
		ArrayList<Board> list = bmapper.selectAll(startRow,endRow,category,s_word);
		// map에 내용 추가하기
		map.put("list", list);
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("page", page);
		map.put("category", category);
		map.put("s_word", s_word);
		
		return map;
	}

	@Override
	public HashMap<String, Object> selectOne(int bno) {
		HashMap<String, Object> map = new HashMap<>(); 
		Board b= bmapper.selectOne(bno);
		Board prev = bmapper.selectPrev(bno);
		Board next = bmapper.selectNext(bno);
		map.put("board", b);
		map.put("prev", prev);
		map.put("next", next);
		
//		System.out.println("prev bno : "+prev.getBno());
//		System.out.println("board bno : "+b.getBno());
//		System.out.println("next bno : "+next.getBno());
		return map;
	}

	@Override
	public void insertOne(Board b) {
		bmapper.insertOne(b);
		
	}

	@Override
	public void replyOne(Board b) {
		bmapper.replyOne(b);
		bmapper.updateBStepCount(b);
		
	}

}
