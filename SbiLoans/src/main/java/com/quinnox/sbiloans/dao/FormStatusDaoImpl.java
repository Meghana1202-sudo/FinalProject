package com.quinnox.sbiloans.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.sbiloans.dto.Customer;
import com.quinnox.sbiloans.dto.FormStatus;

@Repository
public class FormStatusDaoImpl implements FormStatusDao {

	@Autowired
	EntityManager manager;
	
	@Autowired
   CustomerDao CustomerDao;
	
	@Override
	@Transactional
	public boolean addFormStatusDetails(FormStatus details) {
		
		if (CustomerDao.searchCustomer(details.getApplicationId()) != null) {
			Customer customer1 = CustomerDao.searchCustomer(details.getApplicationId());
			if (customer1.getAnnualIncome() > customer1.getLoanAmount()) {
				details.setStatus("Accepted");
				
			} else {
				details.setStatus("Rejected");
			}
		 
		}
		manager.persist(details);
		
		return true;
	}

	@Override
	@Transactional
	public FormStatus searchFormStatusDetails(int id) {
		
		FormStatus bean = manager.find(FormStatus.class, id);
		
		if (bean != null) {
			return bean;
		}
		return bean;
	
	}

	@Override
	@Transactional
	public List<FormStatus> getAllFormStatus() {
		String jpql = "from FormStatus";
		Query query = manager.createQuery(jpql);
		List<FormStatus> list = query.getResultList();
		return list;
	}

	@Override
	public boolean deleteFormStatus(int id) {
		FormStatus status = manager.find(FormStatus.class, id);
		if (status != null) {
			
			manager.remove(status );
		}
		return true;
	}

	@Override
	public boolean updateFormStatusDetails(FormStatus details) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean requestLoans(FormStatus status, int applicationId) {
	     Customer cust = new Customer();
			cust.setApplicationId(applicationId);
			cust.getCustomerName();
		
			
				manager.merge(cust);
				
				return true;
			
	}

	@Override
	@Transactional
	public boolean removeLoansreq(int applicationId) {
		FormStatus status = manager.find(FormStatus.class,applicationId);
		if (status == null) {
			return false;
		}
		
		manager.remove(status);
		return true;

	}


}
