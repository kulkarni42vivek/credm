package com.credm.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.credm.test.models.ResponseMessage;
import com.credm.test.models.Vendor;

@Service
public interface MailService {


	ResponseMessage sendVendorEmails(List<Vendor> vendorList);
	
}
