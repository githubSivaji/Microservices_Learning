package com.microservices.accounts.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false) 
	private long accountNumber;
	
	private Long customerId;
	
	private String accountType;
	
	private String branchAddress;

}
