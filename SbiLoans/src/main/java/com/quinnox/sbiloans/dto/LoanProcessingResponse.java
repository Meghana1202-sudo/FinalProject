package com.quinnox.sbiloans.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LoanProcessingResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<UserInfo> users;
	private List<Customer> customer;
	private List<LoanType> loantype;
	private List<LoanStatus> loanstatus;
	private List<FormStatus> formstatus;
	
	
	
	public List<LoanStatus> getLoanstatus() {
		return loanstatus;
	}
	public void setLoanstatus(List<LoanStatus> loanstatus) {
		this.loanstatus = loanstatus;
	}
	public List<FormStatus> getFormstatus() {
		return formstatus;
	}
	public void setFormstatus(List<FormStatus> formstatus) {
		this.formstatus = formstatus;
	}
	public List<LoanType> getLoantype() {
		return loantype;
	}
	public void setLoantype(List<LoanType> loantype) {
		this.loantype = loantype;
	}
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<UserInfo> getUsers() {
		return users;
	}
	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}
}
