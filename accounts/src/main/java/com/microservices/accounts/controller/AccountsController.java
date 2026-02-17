package com.microservices.accounts.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.accounts.dto.ResponseDTO;

@RestController
@RequestMapping(path="/api",produces= {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {
	
	@GetMapping
	public String sayHello()
	{
		return "hello-world";
	}
	
	@PostMapping("/create")
	public  ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO)
	{
		return null;
	}

}
