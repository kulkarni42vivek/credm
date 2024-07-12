package com.credm.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credm.test.config.Constants;
import com.credm.test.models.Employee;
import com.credm.test.models.ResponseMessage;
import com.credm.test.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo empRepo;

	public ResponseMessage addEmployee(Employee model) {
		try {
			empRepo.save(model);
			return ResponseMessage.builder()
				.errorCode(Constants.ErrorCodes.SUCCESS)
				.errorMessage("Success").build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseMessage.builder()
					.errorCode(Constants.ErrorCodes.ERROR)
					.errorMessage("Error while saving").build();
		}
	}

	public List<Employee> getEmpdata() {
		try {
			return empRepo.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
