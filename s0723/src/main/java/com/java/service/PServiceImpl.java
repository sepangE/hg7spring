package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Product;
import com.java.mapper.PMapper;

@Service
public class PServiceImpl implements PService {

	@Autowired
	PMapper pmapper;
	
	
	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> plist = pmapper.selectAll();
		return plist;
	}


	@Override
	public Product insertProductInfo(Product p) {
		System.out.println("before");
		System.out.println(p.getPno());
		System.out.println(p.getName());
		System.out.println(p.getPrice());
		// 데이터베이스에 p 정보 insert하기
		pmapper.insertOne(p);
		System.out.println("after");
		System.out.println(p.getPno());
		System.out.println(p.getName());
		System.out.println(+p.getPrice());
		Product product = pmapper.selectOne(p);
		
		return product;
	}

}
