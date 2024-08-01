package com.java.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String addr;
	private Timestamp bdate;
	private String email;
	
	private String mailId;
	private String mailTail;
	
	private String phone1;
	private String phone2;
	private String phone3;
	
	private String zip;
	private String addr1;
	private String addr2;
	
	private String year;
	private String month;
	private String day;
	
}