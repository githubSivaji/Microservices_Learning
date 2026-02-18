package com.microservices.accounts.mapper;

import com.microservices.accounts.dto.CustomerDTO;
import com.microservices.accounts.entity.Customer;

public class CustomerMapper {
	
	public static CustomerDTO mapToCustomerDTO(Customer customer,CustomerDTO customerDTO)
	{
		customerDTO.setName(customer.getName());
		customerDTO.setEmail(customer.getMail());
		customerDTO.setMobileNumber(customer.getMobileNumber());
		return customerDTO;
	}
	public static Customer mapToCustomer(Customer customer,CustomerDTO customerDTO)
	{
		customer.setName(customerDTO.getName());
		customer.setMail(customerDTO.getEmail());
		customer.setMobileNumber(customerDTO.getMobileNumber());
		return customer; 
	}

}