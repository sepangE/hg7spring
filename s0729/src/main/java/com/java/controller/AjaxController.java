package com.java.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.Board;
import com.java.dto.GalleryList;
import com.java.service.BService;


@RestController // @Controller + @responseBody
// 데이터만 주고받을때 사용하는 컨트롤러
public class AjaxController {
	
	@Autowired BService bservice;
	
	@PostMapping("/boardList")
	public ArrayList<Board> boardList() {
		ArrayList<Board> blist = bservice.selectAll();
		return blist;
	}
	
	@PostMapping("/insertBoard")
	public Board insertBoard(Board b) {
		System.out.println(b.getId());
		System.out.println(b.getBtitle());
		System.out.println(b.getBcontent());
		Board board = bservice.insertBoard(b);
		return board;
	}
	//------------------------------
	//------------따릉이--------------
	//------------------------------
	@GetMapping("/searchBike")
	public String searchBike(String txt) throws Exception{
		System.out.println("txt : "+ txt);
		int start = Integer.parseInt(txt);
		int end = start+10;
		String key = "707641767668706834357961466f6f";
//		String bikeUrl = "http://openapi.seoul.go.kr:8088/" + 
//				key +"/json/bikeList/1/20/";
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
		urlBuilder.append("/" +  URLEncoder.encode(key,"UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
		urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
		urlBuilder.append("/" + URLEncoder.encode("bikeList","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
		urlBuilder.append("/" + URLEncoder.encode(start+"","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
		urlBuilder.append("/" + URLEncoder.encode(end+"","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
		// 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
		
		// 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다./	
//		urlBuilder.append("/" + URLEncoder.encode("20220301","UTF-8")); /* 서비스별 추가 요청인자들*/
		
		URL url = new URL(urlBuilder.toString());
//		URL url = new URL(bikeUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		BufferedReader rd;

		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
				sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	@GetMapping("/searchSports")
	public String searchSports(String txt) throws Exception{
		String key ="504470694b68706833357a6b437764";
//		String sportsURL ="http://openapi.seoul.go.kr:8088/"+
//		key+"/json/ListPublicReservationSport/1/5";
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
		urlBuilder.append("/" +  URLEncoder.encode(key,"UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
		urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
		urlBuilder.append("/" + URLEncoder.encode("ListPublicReservationSport","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
		urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
		urlBuilder.append("/" + URLEncoder.encode("10","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
		// 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
		
		// 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
		urlBuilder.append("/" + URLEncoder.encode(txt,"UTF-8")); /* 서비스별 추가 요청인자들*/
		
		URL url = new URL(urlBuilder.toString());
//		URL url = new URL(sportsURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		BufferedReader rd;

		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
				sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	@GetMapping("/searchSubway")
	public String searchSubway(String txt) throws Exception{
		System.out.println(txt);
		txt = URLEncoder.encode(txt,"utf-8");
		String key = "585a53676c68706839316143507642";
		String subUrl = "http://swopenapi.seoul.go.kr/api/subway/"+
		key+"/json/realtimeStationArrival/0/10/"+txt;
		System.out.println(subUrl);
		
		URL url = new URL(subUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		BufferedReader rd;

		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
				sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	
	@GetMapping("/searchMovie")
	public String searchMovie(String txt) throws Exception{
		System.out.println(txt);
		String key ="a8272db9974987717ad4f62ed1fff843";
		StringBuilder urlBuilder = new StringBuilder("https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"); /*URL*/
		urlBuilder.append("?"+ URLEncoder.encode("key","UTF-8")+"="+key);
		urlBuilder.append("&"+ URLEncoder.encode("targetDt","UTF-8")+"="+
				URLEncoder.encode(txt,"UTF-8"));
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		BufferedReader rd;

		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
				sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	@GetMapping("/searchPublic")
	public String searchPublic(String txt) throws Exception{
		System.out.println(txt);
		String key = "8CfuxHPeNks82sugbCsk8g8NbzNuom01bOZQybNZfkJpCSoT4OZK0tIm4V7sjBZX1YbjfaTOxEBhQzrIEBvikg%3D%3D";
		String rows = ""+10;
		String page = ""+1;
		
		String result = "";
		if(txt == null || txt.equals("")) {
			// 검색어가 없을때
			result = galleryList(key,rows,page);
		} else {
			// 검색어가 있을때
			result = gallerySearchList(txt,key,rows,page);
		}
		return result;
	}
	// json 검색결과를 db에 저장할 예정
	@Transactional
	public String galleryList(String key, String rows, String page) throws Exception{
		// 검색어 없을때
		StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1"); /*URL*/
		urlBuilder.append("?"+ URLEncoder.encode("serviceKey","UTF-8")+"="+key);
		urlBuilder.append("&"+ URLEncoder.encode("numOfRows","UTF-8")+"="+
				URLEncoder.encode(rows,"UTF-8"));
		urlBuilder.append("&"+ URLEncoder.encode("pageNo","UTF-8")+"="+
				URLEncoder.encode(page,"UTF-8"));
		urlBuilder.append("&"+ URLEncoder.encode("MobileOS","UTF-8")+"="+
				URLEncoder.encode("ETC","UTF-8"));
		urlBuilder.append("&"+ URLEncoder.encode("MobileApp","UTF-8")+"="+
				URLEncoder.encode("AppTest","UTF-8"));
		urlBuilder.append("&"+ URLEncoder.encode("arrange","UTF-8")+"="+
				URLEncoder.encode("A","UTF-8"));
		urlBuilder.append("&"+ URLEncoder.encode("_type","UTF-8")+"="+
				URLEncoder.encode("json","UTF-8"));
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		BufferedReader rd;

		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
				sb.append(line);
		}
		rd.close();
		conn.disconnect();
		//------------------------------------------------------------------
		System.out.println(sb.toString());
		System.out.println("[json 파싱]");
		JSONParser jsonParser = new JSONParser();
		// import는 simple.parser.JSONParser
		JSONObject jsonObject = (JSONObject)jsonParser.parse(sb.toString());
		System.out.println("json object : "+ jsonObject);
		JSONObject jsonObject2 = (JSONObject)jsonObject.get("response");
		JSONObject jsonObject3 = (JSONObject)jsonObject2.get("body");
		JSONObject jsonObject4 = (JSONObject)jsonObject3.get("items");
		JSONArray docuArray = (JSONArray)jsonObject4.get("item");
		System.out.println(docuArray.size());
		for(int i = 0 ; i < docuArray.size() ; i ++ ) {
			JSONObject jObject = (JSONObject) docuArray.get(i);
			System.out.println(jObject.get("galTitle"));
			// json 데이터를 java 오브젝트로 변환 : objectMapper
			ObjectMapper objectMapper = new ObjectMapper();
			GalleryList gallerylist = null;
			// json데이터를 java오브젝트로 변경
			try {
				gallerylist = objectMapper.readValue(jObject.toString(),GalleryList.class);
			} catch(Exception e) { e.printStackTrace();	}
			// 갤러리 1개 데이터 저장
			bservice.insertGallery(gallerylist);
			System.out.println("데이터가 저장되었습니다.");
		}
		//------------------------------------------------------------------
		return sb.toString();
	}

	private String gallerySearchList(String txt, String key, String rows, String page) throws Exception{
		// 검색어 있을때
		StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B551011/PhotoGalleryService1/gallerySearchList1"); /*URL*/
		urlBuilder.append("?"+ URLEncoder.encode("serviceKey","UTF-8")+"="+key);
		urlBuilder.append("&"+ URLEncoder.encode("numOfRows","UTF-8")+"="+
				URLEncoder.encode(rows,"UTF-8"));
		urlBuilder.append("&"+ URLEncoder.encode("pageNo","UTF-8")+"="+
				URLEncoder.encode(page,"UTF-8"));
		urlBuilder.append("&"+ URLEncoder.encode("MobileOS","UTF-8")+"="+
				URLEncoder.encode("ETC","UTF-8"));
		urlBuilder.append("&"+ URLEncoder.encode("MobileApp","UTF-8")+"="+
				URLEncoder.encode("AppTest","UTF-8"));
		urlBuilder.append("&"+ URLEncoder.encode("arrange","UTF-8")+"="+
				URLEncoder.encode("A","UTF-8"));
		urlBuilder.append("&"+ URLEncoder.encode("keyword","UTF-8")+"="+
				URLEncoder.encode(txt,"UTF-8"));
		urlBuilder.append("&"+ URLEncoder.encode("_type","UTF-8")+"="+
				URLEncoder.encode("json","UTF-8"));
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		BufferedReader rd;

		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
				sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		return sb.toString();
	}
	
}
