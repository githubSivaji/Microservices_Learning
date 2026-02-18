package com.microservices.accounts.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity 
@ToString @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity  {
	
	@Id
	private Long accountNumber;
	
	private Long customerId;
	
	private String accountType;
	
	private String branchAddress;

}
