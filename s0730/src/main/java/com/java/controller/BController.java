package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.Board;
import com.java.service.BService;

@Controller
@RequestMapping("/board")
public class BController {
	
	@Autowired
	BService bservice;
	@RequestMapping("/blist")
	public String blist(Model model) {
		ArrayList<Board> list = bservice.selectAll();
		model.addAttribute("list", list);
		return "/board/blist";
	}
	
	@GetMapping("/bwrite")
	public String bwrite() {
		return "/board/bwrite";
	}
	
	@GetMapping("/bwrite2")
	public String bwrite2() {
		return "/board/bwrite2";
	}
	//--------------------------------------------------------
	//------summernote-----------------------------------------
	//--------------------------------------------------------
	@GetMapping("/bwrite3")
	public String bwrite3() {
		return "/board/bwrite3";
	}
	
	@PostMapping("/uploadImage")
	@ResponseBody
	public String uploadImage(@RequestPart MultipartFile afile) throws Exception{
		String urlName="";
		// 파일을 서버로 전송하는 부분
		if(!afile.isEmpty()) {
			String oriFileName = afile.getOriginalFilename();
			long time = System.currentTimeMillis();
			String uploadFileName = time+"_"+oriFileName; // 파일 이름 변경
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl+uploadFileName); // 파일 저장
			afile.transferTo(f);// 파일 서버로 전송
			urlName = "/images/"+uploadFileName;
		}
		System.out.println(urlName);
		
		return urlName;
	}
	
	@PostMapping("/bwrite2")
	public String dobwrite2(Board b,List<MultipartFile> files) throws Exception {
		String fName="";
		String fileName="";
		int i =0;
		for(MultipartFile file: files) {
			String ori_fileName = file.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			fileName = uuid+"_"+ori_fileName;
			String uploadUrl="c:/upload/";
			File f = new File(uploadUrl+fileName);
			file.transferTo(f);
			if(i==0) fName += fileName;
			else fName += ", "+fileName;
			i++;
		}
		b.setBfile(fName);
		bservice.insertOne(b);
		
		return "redirect:blist";
	}
	
	@PostMapping("/bwrite")
	public String dobwrite(@RequestPart MultipartFile file,Board b) {
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
		b.setBfile(fileName); // write일땐 트라이 밖에 modi일땐 안에
		bservice.insertOne(b);
		return "redirect:blist";
	}
	
	@RequestMapping("/bview")
	public String bview(int bno, Model model) {
	//	System.out.println(bno);
		Board board = bservice.selectOne(bno);
		if(!(board.getBfile()==null || board.getBfile().equals(""))) {
			String[] files = board.getBfile().split(", ");
			board.setBfiles(files);
		}
		model.addAttribute("board", board);
		return "/board/bview";
	}
	
	
}
