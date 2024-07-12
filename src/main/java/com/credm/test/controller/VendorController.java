package com.credm.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credm.test.models.ResponseMessage;
import com.credm.test.models.Vendor;
import com.credm.test.service.MailService;
import com.credm.test.service.VendorService;


@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	VendorService vendorService;

	@PostMapping(value = "/addVendor")
	public ResponseEntity<ResponseMessage> addVendor(@RequestBody Vendor model) {
		ResponseMessage responseMessage;
		responseMessage = vendorService.addVendor(model);
		if(responseMessage.getErrorCode() == 3000) {
			return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/getVendorData")
	public ResponseEntity<List<Vendor>> getVendorData() {
		List<Vendor> vendData = vendorService.getVendorData();
		if (vendData!= null && !vendData.isEmpty()) {
			return ResponseEntity.ok(vendData);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}

	
	
}
