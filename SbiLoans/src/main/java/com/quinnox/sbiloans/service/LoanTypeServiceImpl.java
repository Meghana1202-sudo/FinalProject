package com.quinnox.sbiloans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.sbiloans.dao.LoanTypeDao;
import com.quinnox.sbiloans.dto.LoanType;

@Service
public class LoanTypeServiceImpl implements LoanTypeService{
  
	@Autowired
	private LoanTypeDao dao;

	@Override
	public boolean addLoanType(LoanType Type) {
		
		return dao.addLoanType(Type);
	}

	@Override
	public boolean updateLoanType(LoanType Type) {
		
		return dao.updateLoanType(Type);
	}

	@Override
	public List<LoanType> getAllLoanType() {
		
		return dao.getAllLoanType();
	}

	@Override
	public boolean deleteLoanType(int id) {
		
		return dao.deleteLoanType(id);
	}
}

