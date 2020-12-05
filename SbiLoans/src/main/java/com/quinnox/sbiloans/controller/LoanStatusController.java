package com.quinnox.sbiloans.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.sbiloans.dto.LoanProcessingResponse;
import com.quinnox.sbiloans.dto.LoanStatus;
import com.quinnox.sbiloans.service.LoanStatusService;

@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials="true")
@RestController
public class LoanStatusController {
	

	@Autowired
	private LoanStatusService service;
	
	@Autowired
	private LoanProcessingResponse response;
	
	@PostMapping(path = "/add-loanStatus", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoanProcessingResponse addLoanStatus(@RequestBody LoanStatus details) {
		
		if (service.addLoanStatusDetails(details)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Status added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Status wasn't added");
		}
		return response;
	}

	@PutMapping(path = "/update-loanstatus", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoanProcessingResponse updateLoanStatus(@RequestBody LoanStatus bean) {
		
		if (service.updateLoanStatusDetails(bean)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription(" status updated found");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Application Id not found");
		}
		return response;
	}

	@GetMapping(path = "/search-loanstatus/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanProcessingResponse searchLoanStatus(@PathVariable("id") int applicationId) {
		
		LoanStatus beans = service.searchLoanStatus(applicationId);
		if (beans != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Loan status found");
			response.setLoanstatus(Arrays.asList(beans));

		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Loan status not found");

		}
		return response;
	}

	@GetMapping(path = "/get-allloanstatus", produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanProcessingResponse getAllLoanStatus() {

		List<LoanStatus> beans = service.getAllLoanStatus();
		if (beans.isEmpty()) {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Loan status not found");
			response.setLoanstatus(beans);

		} else {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Loan status found");
			// response.setBean(beans);
			response.setLoanstatus(beans);
		}
		return response;
	}


}
