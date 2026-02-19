package com.microservices.accounts.services.Impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.microservices.accounts.constants.AccountsConstants;
import com.microservices.accounts.dto.AccountsDTO;
import com.microservices.accounts.dto.CustomerDTO;
import com.microservices.accounts.entity.Accounts;
import com.microservices.accounts.entity.Customer;
import com.microservices.accounts.exception.CustomerAlreadyExistsException;
import com.microservices.accounts.exception.ResourceNotFoundException;
import com.microservices.accounts.mapper.AccountsMapper;
import com.microservices.accounts.mapper.CustomerMapper;
import com.microservices.accounts.repository.AccountsRepository;
import com.microservices.accounts.repository.CustomerRepository;
import com.microservices.accounts.services.IAccountsService;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class AccountsServiceImpl implements IAccountsService  {
	
	private AccountsRepository accountsRepository;
	private CustomerRepository customerRepository;
	@Override
	public void createAccount(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		Customer customer=CustomerMapper.mapToCustomer(new Customer(), customerDTO);
		Optional<Customer> optionalCustomer=customerRepository.findByMobileNumber(customer.getMobileNumber());
		if(optionalCustomer.isPresent())
		{
			throw new CustomerAlreadyExistsException("Customer already registerd with given mobile number "+customer.getMobileNumber());
		}
		customer.setCreatedAt(LocalDateTime.now());
		customer.setCreatedBy("Sivaji");
		Customer savedCustomer=customerRepository.save(customer); 
		accountsRepository.save(createNewAccount(savedCustomer));
	}
	private Accounts createNewAccount(Customer customer)
	{
		Accounts newAccount =new Accounts();
		newAccount.setCustomerId(customer.getCustomerId());
		long randomAccNumber=10000000L+new Random().nextInt(90000000);
		newAccount.setAccountNumber(randomAccNumber);
		newAccount.setAccountType(AccountsConstants.SAVINGS);
		newAccount.setBranchAddress(AccountsConstants.ADDRESS);
		newAccount.setCreatedAt(LocalDateTime.now());
		newAccount.setCreatedBy("Sivaji");
		return newAccount;
	}
	@Override
	public CustomerDTO fetchAccount(String mobileNumber) {
		  
		Customer customer=customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
				()->new ResourceNotFoundException("Customer","mobileNumber",mobileNumber));
		Accounts accounts =accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
				()->new ResourceNotFoundException("Account","customerId",customer.getCustomerId().toString()));
		CustomerDTO customerDTO=CustomerMapper.mapToCustomerDTO(customer, new CustomerDTO());
		customerDTO.setAccountsDTO(AccountsMapper.mapToAccountsDto(accounts, new AccountsDTO()));
		return customerDTO;
	}
	@Override
	public boolean updateAccount(CustomerDTO customerDTO) {
		
		boolean isUpdated=false;
		AccountsDTO accountsDTO =customerDTO.getAccountsDTO();
		if(accountsDTO!=null)
		{
			Accounts accounts=accountsRepository.findById(accountsDTO.getAccountNumber()).orElseThrow(
					()->new ResourceNotFoundException("Account","AccountNumber",accountsDTO.getAccountNumber().toString()));
		AccountsMapper.mapToAccounts(accounts, accountsDTO);
		accounts=accountsRepository.save(accounts);
		Long customerId=accounts.getCustomerId();
		Customer customer=customerRepository.findById(customerId).orElseThrow(
				()->new ResourceNotFoundException("Customer","CustomerId",customerId.toString()));
		CustomerMapper.mapToCustomer(customer, customerDTO);
		customerRepository.save(customer);
		isUpdated=true;
		}
		return isUpdated;
	}
 
}
