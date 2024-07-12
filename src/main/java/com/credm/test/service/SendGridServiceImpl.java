//package com.credm.test.service;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import com.credm.test.config.Constants;
//import com.credm.test.models.EmailModel;
//import com.credm.test.models.ResponseMessage;
//import com.credm.test.models.Vendor;
//import com.credm.test.repo.EmailRepo;
//import com.credm.test.repo.VendorRepo;
//
//public class SendGridServiceImpl implements MailService {
//
//	@Autowired
//	VendorRepo venderRepo;
//
//	@Autowired
//	EmailRepo emailRepo;
//
//	private static final String EMAIL_SERVICE = "https://mock-email/send";
//
//	@Autowired
//	RestTemplate resttemplate;
//
//	@Override
//	public ResponseMessage sendVendorEmails(List<Vendor> vendorList) {
//		try {
//			for (Vendor vendor : vendorList) {
//				Vendor vendorObj = venderRepo.getReferenceById(vendor.getVendorId());
//				StringBuilder Content = new StringBuilder();
//				Content = Content.append("Sending payments to vendor").append(vendorObj.getName()).append(" at upi ")
//						.append(vendorObj.getUpi());
//
//				Map<String, String> emailPayload = new HashMap<>();
//				emailPayload.put("to", vendorObj.getEmail());
//				emailPayload.put("subject", "Payment Notification");
//				emailPayload.put("body", Content.toString());
//
//				try {
//					ResponseEntity<ResponseMessage> response = resttemplate.postForEntity(EMAIL_SERVICE, emailPayload,
//							ResponseMessage.class);
//
//					HttpStatus statusCode = (HttpStatus) response.getStatusCode();
//					if (statusCode == HttpStatus.OK) {
//						ResponseMessage responseBody = response.getBody();
//						EmailModel emailSent = EmailModel.builder().email(Content.toString()).vendor(vendorObj.getVendorId())
//								.build();
//						emailRepo.save(emailSent);
//					} else {
//						System.out.println("Failed to send email to ");
//					}
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			return ResponseMessage.builder().errorCode(Constants.ErrorCodes.SUCCESS).errorMessage("Success").build();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseMessage.builder().errorCode(Constants.ErrorCodes.ERROR)
//					.errorMessage("Error while Sending Email").build();
//		}
//	}
//
//	@Override
//	public List<EmailModel> getVendorMailsList() {
//		try {
//			return emailRepo.findAll();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//}
