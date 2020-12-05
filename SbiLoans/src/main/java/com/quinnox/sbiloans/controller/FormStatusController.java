package com.quinnox.sbiloans.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.sbiloans.dto.FormStatus;
import com.quinnox.sbiloans.dto.LoanProcessingResponse;
import com.quinnox.sbiloans.service.FormStatusService;

@CrossOrigin(origins="*",allowedHeaders="*")
	@RestController
	public class FormStatusController {
		
		@Autowired
		FormStatusService service;
		
		@Autowired
		private LoanProcessingResponse response;
		
		@PostMapping(path = "/add-formstatus", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

		public LoanProcessingResponse addStatus(@RequestBody FormStatus details) {
			

			if (service.addFormStatusDetails(details)) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Status added successfully");
				return response;
			} else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setDescription("Status wasn't added");
				return response;
			}
			
		}

		@PutMapping(path = "/modify-status", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public LoanProcessingResponse updateStatus(@RequestBody FormStatus bean) {
			
			if (service.updateFormStatusDetails(bean)) {
				response.setStatusCode(200);
				response.setMessage("success");
				response.setDescription("Status updated successfully");
			} else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Application Id not found");
			}
			return response;
		}

		@GetMapping(path = "/search-formstatus/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public LoanProcessingResponse searchFormStatus(@PathVariable("id") int id) {
			
			FormStatus beans = service.searchFormStatusDetails(id);
			if (beans != null) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Form status found");
				response.setFormstatus(Arrays.asList(beans));

			} else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setDescription("Form status not found");

			}
			return response;
		}

		@GetMapping(path = "/get-allformstatus", produces = MediaType.APPLICATION_JSON_VALUE)
		public LoanProcessingResponse getAllFormStatus() {
			
			List<FormStatus> beans = service.getAllFormStatus();
			if (beans !=null) {
				
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Form status found");
				response.setFormstatus(beans);
				return response;

			} else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setDescription("Form status not found");
				return response;
			}
			

	}
		
		@DeleteMapping(path = "/delete-form")
		public LoanProcessingResponse deleteFormStatus(int id) {
			
			if (service.deleteFormStatus(id)) {
				response.setStatusCode(200);
				response.setMessage("success");
				response.setDescription("Loan type deleted successfully");
				return response;
			} else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Loan type not deleted");
				return response;
			}
			
		}
		
		
		@PostMapping(path = "/acceptreq", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public LoanProcessingResponse  addBook(@RequestBody FormStatus request,HttpServletRequest req) {
			if (service.addFormStatusDetails(request)) {
				
				service.deleteFormStatus(request.getApplicationId());
				response.setStatusCode(200);
				response.setMessage("success");
				response.setDescription("Data inserted.");
				return response;
			} else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Data not inserted.");
				return response;
			}
			
			
		}
		
		@PostMapping(path = "/allocateform/{applicationId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public LoanProcessingResponse   LoanReg(@PathVariable("applicationId")  int applicationId,@RequestBody FormStatus status,HttpServletRequest request) {
			if (service.requestLoans(status, applicationId)) {
				System.out.println(service.deleteFormStatus(applicationId));
				response.setStatusCode(200);
				response.setMessage("success");
				response.setDescription("Data inserted.");
				return response;
			} else {
				response.setStatusCode(400);
				response.setMessage("failure");
				response.setDescription("Data not inserted");
				return response;
			}
			
			
		}
		
		@PostMapping(path = "/loanaction/{applicationId}", produces = MediaType.APPLICATION_JSON_VALUE)
		public LoanProcessingResponse   searchcust(@PathVariable("applicationId") int applicationId,@RequestBody FormStatus status,HttpServletRequest req) {
			if (service.removeLoansreq(applicationId)) {			
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("data  successfully deleted..");
				return response;
			} else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("data not successfully deleted..");
				return response;
			}
		}
}
