package com.java.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MemberDto {
	private String id, pw, name, gender, job, hobby;
	
}
