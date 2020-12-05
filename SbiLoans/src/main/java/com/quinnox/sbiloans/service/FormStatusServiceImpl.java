package com.quinnox.sbiloans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.sbiloans.dao.FormStatusDao;
import com.quinnox.sbiloans.dto.FormStatus;

@Service
public class FormStatusServiceImpl implements FormStatusService {
 
	@Autowired
	private FormStatusDao dao;
	
	
	@Override
	public boolean addFormStatusDetails(FormStatus details) {
		return dao.addFormStatusDetails(details);
	}

	@Override
	public boolean updateFormStatusDetails(FormStatus details) {
		
		return dao.updateFormStatusDetails(details);
	}

	@Override
	public FormStatus searchFormStatusDetails(int id) {
		
		return dao.searchFormStatusDetails(id);
	}

	@Override
	public List<FormStatus> getAllFormStatus() {
	
		return dao.getAllFormStatus();
	}

	@Override
	public boolean deleteFormStatus(int id) {
		
		return dao.deleteFormStatus(id);
	}

	@Override
	public boolean requestLoans(FormStatus status, int applicationId) {
	
		return dao.requestLoans(status, applicationId);
	}

	@Override
	public boolean removeLoansreq(int applicationId) {
		
		return dao.removeLoansreq(applicationId);
	}



}

