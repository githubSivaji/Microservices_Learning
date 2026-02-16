package com.microservices.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Customer extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false) 
	private long accountNumber;
	
	private Long customerId;
	
	private String accountType;
	
	private String branchAddress;

}
