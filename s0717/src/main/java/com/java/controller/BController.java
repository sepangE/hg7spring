package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.Board;
import com.java.service.BoardService;

@Controller
@RequestMapping("/board")
public class BController {
	
	@Autowired
	BoardService bservice;

	@RequestMapping("/blist")
	public String blist(Model model) {
		ArrayList<Board> list = bservice.selectBoardAll();
		// 확인용
		//System.out.println(list.get(0).getBtitle());
		
		model.addAttribute("list", list);
		return "board/blist";
	}//blist
	
	@RequestMapping("/bview")
	public String bview(int bno, Model model) {
		//System.out.println(bno);
		Board b = bservice.selectOneBoard(bno);
		bservice.updateBhitUp(bno);
		System.out.println(b.getBhit());
		//System.out.println(b.getBtitle());
		model.addAttribute("board", b);
		return "board/bview";
	} //bview
	
	@GetMapping("/bwrite")
	public String bwrite() {
		System.out.println("Get방식으로 들어옴");
		return "board/bwrite";
	}//bwrite 글쓰기 화면 출력
	
	@PostMapping("/bwrite")
	public String doBwrite(Board board, Model model,
			@RequestPart MultipartFile file) {
		System.out.println("Post방식으로 들어옴");
		String fileName="";
		// 파일이 있을경우 저장
		if(!file.isEmpty()) {
			String ori_fileName = file.getOriginalFilename();// 실제 파일이름
			UUID uuid = UUID.randomUUID(); // 랜덤숫자 생성
			fileName = uuid+"_"+ori_fileName; // 파일이름 변경(중복방지)
			System.out.println(fileName);
			String uploadUrl = "c:/upload/"; // 파일 업로드 위치
			File f = new File(uploadUrl+fileName);
			try {
				file.transferTo(f); // 파일 저장
			} catch(Exception e) {e.printStackTrace();}
		}
		board.setBfile(fileName);
		//System.out.println("bwrite - fileName : "+ board.getBfile());
		bservice.insertOne(board);
		return "redirect:blist";
	}//bwrite 글쓰기 화면에서 저장버튼 눌렀을때
	
	@GetMapping("/bmodi")
	public String bmodi(int bno, Model model) {
		System.out.println("get으로 게시글 수정");
		//System.out.println(bno);
		Board b = bservice.selectOneBoard(bno);
		//System.out.println(b.getBtitle());
		model.addAttribute("board", b);
		return "board/bmodi";
	}
	@PostMapping("/bmodi")
	public String doBmodi(Board board,@RequestPart MultipartFile file) {
		System.out.println("post으로 게시글 수정");
		String fileName="";
		// 파일이 있을경우 저장
		if(!file.isEmpty()) {
			String ori_fileName = file.getOriginalFilename();// 실제 파일이름
			UUID uuid = UUID.randomUUID(); // 랜덤숫자 생성
			fileName = uuid+"_"+ori_fileName; // 파일이름 변경(중복방지)
			System.out.println(fileName);
			String uploadUrl = "c:/upload/"; // 파일 업로드 위치
			File f = new File(uploadUrl+fileName);
			try {
				file.transferTo(f); // 파일 저장
				board.setBfile(fileName);
			} catch(Exception e) {e.printStackTrace();}
		}
		bservice.updateOne(board);
		return "redirect:blist";
	}
	
	@RequestMapping("/bdelete")
	public String bdelete(int bno) {
		
		bservice.deleteOne(bno);
		return "redirect:blist";
	}
	
	
	
	
}