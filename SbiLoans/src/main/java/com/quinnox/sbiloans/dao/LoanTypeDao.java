package com.quinnox.sbiloans.dao;

import java.util.List;

import com.quinnox.sbiloans.dto.LoanType;

public interface LoanTypeDao {
	
	public boolean addLoanType(LoanType Type);
	public boolean updateLoanType(LoanType Type);
	
	public List<LoanType> getAllLoanType();
    
    public boolean deleteLoanType(int id);
 

}

