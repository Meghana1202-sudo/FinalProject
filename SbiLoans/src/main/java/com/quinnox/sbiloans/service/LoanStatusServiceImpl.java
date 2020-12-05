package com.quinnox.sbiloans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.sbiloans.dao.LoanStatusDao;
import com.quinnox.sbiloans.dto.LoanStatus;

@Service
public class LoanStatusServiceImpl implements LoanStatusService{
 
	@Autowired
	private LoanStatusDao dao;
	
	@Override
	public boolean addLoanStatusDetails(LoanStatus details) {
	
		return dao.addLoanStatusDetails(details);
	}

	@Override
	public boolean updateLoanStatusDetails(LoanStatus bean) {
	
		return dao.updateLoanStatusDetails(bean);
	}

	@Override
	public LoanStatus searchLoanStatus(int id) {
		
		return dao.searchLoanStatus(id);
	}

	@Override
	public List<LoanStatus> getAllLoanStatus() {
		
		return dao.getAllLoanStatus();
	}
	

}
