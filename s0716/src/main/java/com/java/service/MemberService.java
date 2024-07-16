package com.java.service;

import java.util.ArrayList;
import java.util.List;
import com.java.dto.Member;

public interface MemberService {
	ArrayList<Member> memberSelectAll();

	Member memberSelectOne(String id);

	Member selectLogin(String id, String pw);

}




