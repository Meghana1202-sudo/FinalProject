package com.quinnox.sbiloans.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name="applicationId")
	@GeneratedValue
	private int applicationId;
	
	@Column(name="customerName")
	private String customerName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(name="customerPhoneNo")
	private long customerPhoneNo;
	
	@Column(name="address")
	private String address;
	
	@Column(name="dateOfBirth")
	private String dateOfBirth;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="occupation")
	private String occupation;
	
	@Column(name="annualIncome")
	private long annualIncome;
	
	@Column(name="assurerName")
	private String assurerName;
	
	@Column(name="assurerContactNumber")
	private long assurerContactNumber;
	
	@Column(name="assurerAddress")
	private String assurerAddress;
	
	@Column(name="loanType")
	private String loanType;
	
	@Column(name="loanAmount")
	private long loanAmount;
	
	@Column(name="status")
	private String status="pending";
	
	@Column(name="interviewDate")
	private String interviewDate;
	
  
	
}
