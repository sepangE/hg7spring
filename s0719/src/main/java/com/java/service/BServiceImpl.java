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
	BMapper bMapper;
	
	@Override
	public HashMap<String, Object> selectAll(int page) {
		HashMap<String, Object> map = new HashMap<>();
		//1. 총 게시글의 수
		int listCount = bMapper.selectlistCount();
		//2. 최대페이지
		int maxPage = (int)Math.ceil(listCount/10.0);
		//3. 시작페이지, 엔드페이지
		int startPage = (int)((page-1)/10)*10+1;
		int endPage = startPage+10-1;
		// page= 2면 1 2 3 4 5 6 7 8 9 10
		// page = 22면 21 22 ......... 30
		//4. startRow, endRow
		int startRow = (page-1)*10+1;
		int endRow = startRow+10-1;
		
		if(endPage > maxPage) endPage = maxPage;
		
		
		System.out.println("게시글 수 : "+listCount);
		System.out.println("현재 페이지: "+page);
		System.out.println("최대 페이지: "+maxPage);
		System.out.println("strat row : "+startRow);
		System.out.println("end row : "+endRow);
		
		ArrayList<Board> list = bMapper.selectAll(startRow,endRow);
		map.put("list", list);
		map.put("listCount", listCount);
		map.put("endPage", endPage);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("startPage", startPage);
		map.put("maxPage", maxPage);
		map.put("page", page);
		return map;
	}

	@Override
	public void bhitUp(int bno) {
		bMapper.bhitUp(bno);
		
	}

	@Override
	public Board selectOne(int bno) {
		Board b = bMapper.selectOne(bno);
		return b;
	}

	@Override
	public void deleteOne(int bno) {
		bMapper.deleteOne(bno);
		
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
	public void replyOne(Board b) {
		// 1. 답글게시글을 추가하는 부분
		bMapper.insertReplyOne(b);
		// 2. bstep 조정하는 부분
		bMapper.updateBstepCount(b);
	}

}
