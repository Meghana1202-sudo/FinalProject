package com.quinnox.sbiloans.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="loanstatus")
public class LoanStatus {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="applicationId")
	private int applicationId;
	
	@Column(name="loanStatus")
	private String loanStatus;
	

}
