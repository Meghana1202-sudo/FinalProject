package com.quinnox.sbiloans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.sbiloans.dto.LoanProcessingResponse;
import com.quinnox.sbiloans.dto.LoanType;
import com.quinnox.sbiloans.service.LoanTypeService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class LoanTypeController {
	@Autowired
	private LoanTypeService service;
	
	@Autowired
	private LoanProcessingResponse response;
	
	@PostMapping(path = "/add-loan", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoanProcessingResponse addLoanType(@RequestBody LoanType Type) {
		
		if (service.addLoanType(Type)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Loan added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Loan already exists");
		}
		return response;
	}

	@PutMapping(path = "/update-type", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoanProcessingResponse updateLoanType(@RequestBody LoanType Type) {
		
		if (service.updateLoanType(Type)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Loan  updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Application Id not found");
		}
		return response;
	}


	@GetMapping(path = "/get-alltype", produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanProcessingResponse getAllLoans() {
		
		List<LoanType> type = service.getAllLoanType();
		if(type != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Loan data found");
			response.setLoantype(type);

		} else {
			
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Loan data not found");
		}
		return response;
	}

	@DeleteMapping(path = "/delete-loanType")
	public LoanProcessingResponse deleteLoanType(int id) {
		
		if (service.deleteLoanType(id)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("Loan type deleted.");
			return response;
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Loan type not deleted.");
			return response;
		}	
	}
}
