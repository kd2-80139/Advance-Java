package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ApiResponse {

	private LocalDateTime time;
	private String mesg;
	
	public ApiResponse(String messege) {
		// TODO Auto-generated constructor stub
		this.mesg=messege;
		this.time=LocalDateTime.now();
	}
	
}
