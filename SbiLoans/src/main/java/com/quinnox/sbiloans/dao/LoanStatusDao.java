package com.quinnox.sbiloans.dao;

import java.util.List;

import com.quinnox.sbiloans.dto.LoanStatus;

public interface LoanStatusDao {
	
	public boolean addLoanStatusDetails(LoanStatus details);

	public boolean updateLoanStatusDetails(LoanStatus bean);
	public LoanStatus searchLoanStatus(int id);
	public List<LoanStatus> getAllLoanStatus();


}

