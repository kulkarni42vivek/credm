package com.credm.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.credm.test.config.Constants;
import com.credm.test.models.EmailModel;
import com.credm.test.models.ResponseMessage;
import com.credm.test.models.Vendor;
import com.credm.test.repo.EmailRepo;
import com.credm.test.repo.VendorRepo;

public class GenericMailService implements MailService {

	@Autowired
	EmailRepo emailRepo;
	
	@Autowired
	VendorRepo venderRepo;

	@Override
	public ResponseMessage sendVendorEmails(List<Vendor> vendorList) {
		try {
			for (Vendor vendor : vendorList) {
				Vendor vendorObj = venderRepo.getReferenceById(vendor.getVendorId());
				StringBuilder Content = new StringBuilder();
				Content = Content.append("Sending payments to vendor").append(vendorObj.getName()).append(" at upi ")
						.append(vendorObj.getUpi());
				EmailModel emailSent = EmailModel.builder().email(Content.toString())
						.vendor(vendorObj.getVendorId()).build();

				emailRepo.save(emailSent);
			}
			return ResponseMessage.builder().errorCode(Constants.ErrorCodes.SUCCESS).errorMessage("Success").build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.builder().errorCode(Constants.ErrorCodes.ERROR)
					.errorMessage("Error while Sending Email").build();
		}
	}

	@Override
	public List<EmailModel> getVendorMailsList() {
		try {
			return emailRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
