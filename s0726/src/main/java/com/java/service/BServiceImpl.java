package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.dto.Cboard;
import com.java.mapper.BMapper;

@Service
public class BServiceImpl implements BService {
	
	
	@Autowired BMapper bMapper;
	
	
	public HashMap<String, Object> selectAll(String category, String sWord, int page) {
		HashMap<String, Object> map = new HashMap<>();
		System.out.println(sWord);
		System.out.println(category);
		//1. 전체 게시물 수 
				int listCount = bMapper.selectListCount(category,sWord);
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
				ArrayList<Board> list = bMapper.selectAll(startRow,endRow,category,sWord);
				
				map.put("listCount", listCount);
				map.put("maxPage", maxPage);
				map.put("startPage", startPage);
				map.put("endPage", endPage);
				map.put("startRow", startRow);
				map.put("endRow", endRow);
				map.put("list", list);
				map.put("page", page);
				map.put("category", category);
				map.put("sWord", sWord);
				
		return map;
	}


	@Override
	public HashMap<String,Object> selectOne(int bno, String category, String sWord, int page) {
		
		System.out.println("bService");
		HashMap<String,Object> map = new HashMap<>();
		Board b = bMapper.selectOne(bno,category,sWord);
		bMapper.bhitUp(bno);
		Board prev = bMapper.selectPrev(bno,category,sWord);
		System.out.println("bService");
		Board next = bMapper.selectNext(bno,category,sWord);
		ArrayList<Cboard> clist = bMapper.selectAllReply(bno);
		map.put("board", b);
		map.put("prev", prev);
		map.put("next", next);
		map.put("page", page);
		map.put("category", category);
		map.put("sWord", sWord);
		map.put("clist", clist);

		return map;
	}


	@Override
	public Cboard insertReply(Cboard comm) {
		bMapper.insertReply(comm);
		System.out.println(comm.getCno());
		Cboard comment = bMapper.selectOneReply(comm);
		return comment;
	}


	@Override
	public void delOneReply(int cno) {
		bMapper.delOneReply(cno);
		
	}


	@Override
	public Cboard updateComm(Cboard comm) {
		bMapper.updateComm(comm);
		Cboard comment = bMapper.selectOneReply(comm);
		return comment;
	}

}
