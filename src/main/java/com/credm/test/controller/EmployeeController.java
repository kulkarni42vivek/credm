package com.credm.test.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credm.test.config.Constants;
import com.credm.test.models.Employee;
import com.credm.test.models.ResponseMessage;
import com.credm.test.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@PostMapping( "/addEmployee")
	public ResponseEntity<ResponseMessage> addEmployee(@RequestBody Employee model) {
		ResponseMessage responseMessage ;
		responseMessage = empService.addEmployee(model);
		if(responseMessage.getErrorCode() == Constants.ErrorCodes.SUCCESS) {
			return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/getEmpdata")
	public ResponseEntity<List<Employee>> getEmpdata() {
		List<Employee> empData = empService.getEmpdata();
//		if (empData!= null && empData.size() > 0) {
//			return ResponseEntity.ok(empData);
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//		}
		
		
		return ResponseEntity.ok(empData);
	}

}
