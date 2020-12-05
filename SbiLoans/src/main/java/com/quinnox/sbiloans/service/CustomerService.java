package com.quinnox.sbiloans.service;

import java.util.List;

import com.quinnox.sbiloans.dto.Customer;

public interface CustomerService {
	
	public boolean addCustomer(Customer customer);

	public boolean deleteCustomer(int applicationId);

	public Customer searchCustomer(int applicationId);

	public List<Customer> getAllCustomers();

	public boolean updateCustomer(Customer customer);
	
	public boolean requestCust(Customer customer,int applicationId);

	boolean delReq(int applicationId);

	boolean addReq(int applicationId);

	boolean updateCustomer(int applicationId);


}

