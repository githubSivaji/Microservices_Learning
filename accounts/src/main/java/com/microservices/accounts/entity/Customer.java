package com.microservices.accounts.entity;

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
public class Customer extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id") 
	private long accountNumber;
	
	private String name;
	
	private String mail;
	
	private int mobileNumber;

}
