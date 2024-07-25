package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Product;
import com.java.service.PService;

@Controller
public class FController {
	
	@Autowired
	PService  pservice;
	
	
	@RequestMapping("/")
	public String index() {
		return "/main";
	} // index
	
	@RequestMapping("/ajax01")
	public String ajax01() {
		return "/ajax01";
	} // ajax01
	
	@RequestMapping("/ajax02")
	public String ajax02() {
		return "/ajax02";
	} // ajax02
	
	@RequestMapping("/product")
	public String product() {
		return "/product";
	} // product
	
	@RequestMapping("/productList")
	@ResponseBody
	public ArrayList<Product> productList() {
		ArrayList<Product> plist = pservice.selectAll();
		
		return plist;
	} // product
	
	@RequestMapping("/insertProductInfo")
	@ResponseBody
	public Product insertProductInfo(Product p) {
	//	pservice.insertProductInfo(p);
		System.out.println("name : "+p.getName());
		System.out.println("price : "+p.getPrice());
		System.out.println("category : "+p.getCategory());
		Product product = pservice.insertProductInfo(p);
		
		return product;
	} // product
	
//	@RequestMapping("/insertProductInfo")
//	@ResponseBody
//	public void insertProductInfo(Product p) {
//		pservice.insertProductInfo(p);
//		
//		
//	} // product
	
	
}
