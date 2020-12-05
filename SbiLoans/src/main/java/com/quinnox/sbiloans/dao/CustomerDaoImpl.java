package com.quinnox.sbiloans.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.quinnox.sbiloans.dto.Customer;
import com.quinnox.sbiloans.dto.FormStatus;

public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	EntityManager manager;
	@Override
	@Transactional
	public boolean addCustomer(Customer customer) {
		
		manager.persist(customer);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteCustomer(int applicationId) {
		Customer customer = manager.find(Customer.class, applicationId);
		FormStatus  status = new FormStatus();
		if (customer != null) {
			
			manager.remove(customer);
			status.setStatus("deleted");
		}
		return true;
	}

	@Override
	public Customer searchCustomer(int applicationId) {
		Customer customer = manager.find(Customer.class, applicationId);
		
		if (customer != null) {
			return customer;
		}
		else {
			System.out.println("no data");
		}
		return customer;
		
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		String jpql = "from Customer";
		Query query = manager.createQuery(jpql);
		List<Customer> list = query.getResultList();
		return list;
	}

	@Override
	@Transactional
	public boolean updateCustomer(int   applicationId) {
		Customer status = manager.find(Customer.class, applicationId );
		status.setStatus("Accepted");

		return true;
	}	
	@Override
	@Transactional
	public boolean requestCust(Customer customer, int applicationId) {
		FormStatus status = new FormStatus();
		
        status.setApplicationId(customer.getApplicationId());
    	manager.merge(status);
		return true;
	}

	@Override
	@Transactional
	public boolean addReq(int applicationId) {
		Customer status = manager.find(Customer.class, applicationId );
		
		if(status.getAnnualIncome()>status.getLoanAmount()) {
			
		
		status.setStatus("Accepted");
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 9);
		String newDate = sdf.format(calendar.getTime());
		status.setInterviewDate(newDate);
		}else {
			status.setStatus("Your annual income is less to apply this loan");
			status.setInterviewDate("Not eligible for interview");
		}
		manager.persist(status);
		
		return true;
	}

	@Override
	@Transactional
	public boolean delReq(int applicationId) {
		Customer status = manager.find(Customer.class, applicationId );
		if(status.getAnnualIncome()<status.getLoanAmount()) {
			
		status.setStatus("Rejected");
		status.setInterviewDate("Not eligible for interview");
		}else {
			status.setStatus("Try again.....");
			status.setInterviewDate("Apply again.....:)");
		}
		manager.persist(status);
		return true;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
}



