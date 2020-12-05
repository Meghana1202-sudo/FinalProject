package com.quinnox.sbiloans.service;

import java.util.List;

import com.quinnox.sbiloans.dto.LoanStatus;

public interface LoanStatusService {
	public boolean addLoanStatusDetails(LoanStatus details);

	public boolean updateLoanStatusDetails(LoanStatus bean);
	public LoanStatus searchLoanStatus(int id);
	public List<LoanStatus> getAllLoanStatus();

}
