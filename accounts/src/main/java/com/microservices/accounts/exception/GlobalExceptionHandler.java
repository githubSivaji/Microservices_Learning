package com.microservices.accounts.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservices.accounts.dto.ErrResponseDTO;

@ControllerAdvice 
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
	        MethodArgumentNotValidException ex,
	        HttpHeaders headers,
	        HttpStatusCode status,
	        WebRequest request) {

	    Map<String, String> validationErrors = new HashMap<>();

	    ex.getBindingResult().getFieldErrors().forEach(error -> {
	        validationErrors.put(
	            error.getField(),
	            error.getDefaultMessage()
	        );
	    });

	    return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)   
	public ResponseEntity<ErrResponseDTO> handleGlobalException(Exception exception,WebRequest webRequest)
	{
		ErrResponseDTO errResponseDTO=new ErrResponseDTO(
				webRequest.getDescription(false),
				HttpStatus.INTERNAL_SERVER_ERROR,
				exception.getMessage(),
				LocalDateTime.now()
				);
		return new ResponseEntity<>(errResponseDTO,HttpStatus.BAD_REQUEST);
				
	}
	
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
	
	@ExceptionHandler(ResourceNotFoundException.class)   
	public ResponseEntity<ErrResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest webRequest)
	{
		ErrResponseDTO errResponseDTO=new ErrResponseDTO(
				webRequest.getDescription(false),
				HttpStatus.NOT_FOUND,
				exception.getMessage(),
				LocalDateTime.now()
				);
		return new ResponseEntity<>(errResponseDTO,HttpStatus.BAD_REQUEST);
				
	}

}
