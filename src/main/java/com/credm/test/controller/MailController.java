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

import com.credm.test.models.EmailModel;
import com.credm.test.models.ResponseMessage;
import com.credm.test.models.Vendor;
import com.credm.test.service.MailService;

@RestController
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	MailService mailService;
	
	@PostMapping(value = "/sendVendorEmails")
	public ResponseEntity<ResponseMessage> sendVendorEmails(@RequestBody List<Vendor> vendorList) {
		ResponseMessage responseMessage;
		responseMessage = mailService.sendVendorEmails(vendorList);
		if (responseMessage.getErrorCode() == 3000) {
			return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
		} else {
			return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/getVendorMailsList")
	public ResponseEntity<List<EmailModel>> getVendorMailsList() {
		List<EmailModel> emailData = mailService.getVendorMailsList();
		if (emailData!= null && !emailData.isEmpty()) {
			return ResponseEntity.ok(emailData);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
}
