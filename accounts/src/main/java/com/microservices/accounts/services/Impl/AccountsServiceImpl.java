package com.microservices.accounts.services.Impl;

import org.springframework.stereotype.Service;

import com.microservices.accounts.dto.CustomerDTO;
import com.microservices.accounts.services.IAccountsService;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class AccountsServiceImpl implements IAccountsService  {
	
	
	@Override
	public void createAccount(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		
	}
 
}
