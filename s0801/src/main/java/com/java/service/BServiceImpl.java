package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.mapper.BMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired BMapper bMapper;

	@Override
	public HashMap<String, Object> selectAll(int page, String category, String sWord) {
		HashMap<String, Object> map = new HashMap<>();
		//1. 전체 게시물 수 
				int listCount = bMapper.selectListCount(category, sWord);
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
				System.out.println(endPage);
				System.out.println(maxPage);
				ArrayList<Board> list = bMapper.selectAll(category,sWord,startRow,endRow);
				
				map.put("list", list);
				map.put("page", page);
				map.put("listCount", listCount);
				map.put("maxPage", maxPage);
				map.put("startPage", startPage);
				map.put("endPage", endPage);
				map.put("startRow", startRow);
				map.put("endRow", endRow);
				map.put("category", category);
				map.put("sWord", sWord);
				
		return map;
	}

	@Override
	public HashMap<String, Object> selectOne(int bno, String sWord, int page, String category) {
		HashMap<String, Object> map = new HashMap<>();
		Board board = bMapper.selectOne(bno);
		bMapper.bhitUp(bno);
		Board prev = bMapper.selectPrev(bno,sWord,category);
//		System.out.println(prev.getBtitle());
		Board next = bMapper.selectNext(bno,sWord,category);
//		System.out.println(next.getBtitle());
		map.put("board", board);
		map.put("prev", prev);
		map.put("next", next);
//		System.out.println(board.getBno());
//		System.out.println("prev"+prev.getBno());
//		System.out.println("next"+next.getBno());
		return map;
	}

	@Override
	public void insertBoard(Board b) {
		bMapper.insertBoard(b);
		
	}

	@Override
	public void deleteBoard(int bno) {
		bMapper.deleteBoard(bno);
		
	}

	@Override
	public Board modiBaord(int bno) {
		Board board = bMapper.selectOne(bno);
		return board;
	}

	@Override
	public void updateBoard(Board b) {
		bMapper.updateBoard(b);
		
	}

	@Override
	public Board replyBoard(int bno) {
		Board b = bMapper.selectOne(bno);
		return b;
	}
	
	
	
}
