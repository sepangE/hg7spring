package com.java.service;

import com.java.dto.Member;

public interface MService {

	Member selectLogin(String id, String pw);

	Member searchId(String name, String phone);

}