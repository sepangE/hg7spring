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
	public HashMap<String, Object> selectAll(int page, String category, String sWord) {
		// 확인용
		System.out.println("category : " + category);
		System.out.println("sWord : " + sWord);
		HashMap<String, Object> map = new HashMap<>();
		//1. 전체 게시물 수 
		int listCount = bmapper.selectListCount(category, sWord);
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
		
		System.out.println("listCount : "+ listCount);		
				
		ArrayList<Board> list = bmapper.selectAll(startRow,endRow,category,sWord);
	//	System.out.println(list.get(0).getBtitle());
		map.put("list", list);
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("page", page);
		map.put("category", category);
		map.put("sWord", sWord);
		
		return map;
	}

	@Override
	public HashMap<String, Object> selectOne(int bno, String category, String sWord) {
		HashMap<String, Object> map = new HashMap<>();
		Board b = bmapper.selectOne(bno);
		Board prev = bmapper.selectPrev(bno,category,sWord);
		Board next = bmapper.selectnext(bno,category,sWord);
		//System.out.println(b.getBtitle());
		map.put("board", b);
		map.put("prev", prev);
		map.put("next", next);
		return map;
	}

}
