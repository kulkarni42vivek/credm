package com.credm.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.credm.test.config.Constants;
import com.credm.test.exception.CustomMailException;
import com.credm.test.models.EmailModel;
import com.credm.test.models.ResponseMessage;
import com.credm.test.models.Vendor;
import com.credm.test.repo.EmailRepo;
import com.credm.test.repo.VendorRepo;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class VendorService {

	@Autowired
	VendorRepo venderRepo;

	public ResponseMessage addVendor(Vendor model) {
		try {
			venderRepo.save(model);
			return ResponseMessage.builder().errorCode(Constants.ErrorCodes.SUCCESS).errorMessage("Success").build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.builder().errorCode(Constants.ErrorCodes.ERROR).errorMessage("Error while saving")
					.build();
		}
	}

	public List<Vendor> getVendorData() {
		try {
			return venderRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
