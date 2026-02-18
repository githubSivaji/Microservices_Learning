package com.microservices.accounts.mapper;

import com.microservices.accounts.dto.AccountsDTO;
import com.microservices.accounts.entity.Accounts;

public class AccountsMapper {
	
	public static AccountsDTO mapToAccountsDto(Accounts accounts,AccountsDTO accountsDTO)
	{
		accountsDTO.setAccountNumber(accounts.getAccountNumber());
		accountsDTO.setAccountType(accounts.getAccountType());
		accountsDTO.setBranchAddress(accounts.getBranchAddress());
		return accountsDTO;
	}  
	public static Accounts mapToAccounts(Accounts accounts,AccountsDTO accountsDTO)
	{ 
		accounts.setAccountNumber(accountsDTO.getAccountNumber());
		accounts.setAccountType(accountsDTO.getAccountType());
		accounts.setBranchAddress(accountsDTO.getBranchAddress());
		return accounts;
	}
}
