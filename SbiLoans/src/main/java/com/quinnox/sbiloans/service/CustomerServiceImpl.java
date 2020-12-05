package com.quinnox.sbiloans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.sbiloans.dao.CustomerDao;
import com.quinnox.sbiloans.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;
	
	@Override
	public boolean addCustomer(Customer customer) {
		
		return dao.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int applicationId) {
		
		return dao.deleteCustomer(applicationId);
	}

	@Override
	public Customer searchCustomer(int applicationId) {
		
		return dao.searchCustomer(applicationId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return dao.getAllCustomers();
	}

	@Override
	public boolean updateCustomer(int applicationId) {
	
		return dao.updateCustomer(applicationId);
	}

	@Override
	public boolean requestCust(Customer customer, int applicationId) {
		
		return dao.requestCust(customer, applicationId);
	}

	@Override
	public boolean addReq(int applicationId) {
		
		return dao.addReq(applicationId);
	}

	@Override
	public boolean delReq(int applicationId) {
		
		return dao.delReq(applicationId);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		
		return false;
	}	
}
