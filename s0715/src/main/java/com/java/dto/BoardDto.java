package com.java.dto;

import java.security.Timestamp;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// data = getter & setter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BoardDto {
	private int bno, bhit, bgroup, bstep, bindent;
	private String id, btitle, bcontent, bfile;
	private Timestamp bdate;
}
