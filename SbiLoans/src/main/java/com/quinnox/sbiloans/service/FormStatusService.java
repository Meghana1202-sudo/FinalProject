package com.quinnox.sbiloans.service;

import java.util.List;

import com.quinnox.sbiloans.dto.FormStatus;

public interface FormStatusService {
	
	public boolean addFormStatusDetails(FormStatus details);

	public boolean updateFormStatusDetails(FormStatus details);

	public FormStatus searchFormStatusDetails(int id);

	public List<FormStatus> getAllFormStatus();

	public boolean deleteFormStatus(int id);

	public boolean requestLoans(FormStatus status, int applicationId);
	
	public boolean removeLoansreq(int applicationId);


}
