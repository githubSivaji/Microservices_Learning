package com.microservices.accounts.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor  
public class ErrResponseDTO {
	
	private String apiPath;
	
	private HttpStatus errcode;
	
	private String errorMessage;
	
	private LocalDateTime errorTime;
	

}
