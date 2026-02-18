package com.microservices.accounts.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.microservices.accounts.dto.ErrResponseDTO;

@ControllerAdvice 
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerAlreadyExistsException.class) 
	public ResponseEntity<ErrResponseDTO> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception,WebRequest webRequest)
	{
		ErrResponseDTO errResponseDTO=new ErrResponseDTO(
				webRequest.getDescription(false),
				HttpStatus.BAD_REQUEST,
				exception.getMessage(),
				LocalDateTime.now()
				);
		return new ResponseEntity<>(errResponseDTO,HttpStatus.BAD_REQUEST);
				
	}

}
