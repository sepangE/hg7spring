package com.java.service;

import org.springframework.stereotype.Service;

@Service

public class BServiceImpl2 implements BService {

	@Override
	public int add() {
		
		return 100+200;
	}

}
