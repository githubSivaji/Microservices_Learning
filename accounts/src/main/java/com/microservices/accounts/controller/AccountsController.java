package com.microservices.accounts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.accounts.constants.AccountsConstants;
import com.microservices.accounts.dto.CustomerDTO;
import com.microservices.accounts.dto.ResponseDTO;
import com.microservices.accounts.services.IAccountsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor 
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountsController {  
    
	private IAccountsService iAccountsService;
    @GetMapping
    public String sayHello() {
        return "hello-world";
    }
    
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO) {
    	iAccountsService.createAccount(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));  
    }
    
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam String mobileNumber)
    { 
    	CustomerDTO customerDTO=iAccountsService.fetchAccount(mobileNumber);
    	return ResponseEntity.status(HttpStatus.OK)
                .body(customerDTO);  
    }
    
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@RequestBody CustomerDTO customerDTO )
    { 
        boolean isUpdated=iAccountsService.updateAccount(customerDTO);
        if(!isUpdated)
        {
        	return ResponseEntity.status(HttpStatus.OK)
        			.body(new ResponseDTO(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        }
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        			.body(new ResponseDTO(AccountsConstants.MESSAGE_500,AccountsConstants.MESSAGE_500));
        
 
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccountDetails(@RequestParam String mobileNumber){
    	boolean isDeleted=iAccountsService.deleteAccount(mobileNumber);
    	if(isDeleted)
    	{
    		return ResponseEntity.status(HttpStatus.OK)
    				.body(new ResponseDTO(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
    	
    		
    	}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDTO(AccountsConstants.STATUS_500,AccountsConstants.MESSAGE_500));
	
    	
    }

} 
