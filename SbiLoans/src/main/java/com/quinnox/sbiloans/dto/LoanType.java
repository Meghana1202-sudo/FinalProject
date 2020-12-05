package com.quinnox.sbiloans.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "loanType")
public class LoanType {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="loanType")
	private String loanType;
	
	@Column(name="duration")
	private double duration;
	
	@Column(name="rateOfInterest")
	private double rateOfInterest;
	
	@Column(name="emi")
	private int emi;
	
	@Column(name="loanAmount")
	private double loanAmount;
	
}
