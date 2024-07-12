//package com.credm.test.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//
//import com.credm.test.config.Constants;
//import com.credm.test.exception.CustomMailException;
//import com.credm.test.models.EmailModel;
//import com.credm.test.models.ResponseMessage;
//import com.credm.test.models.Vendor;
//import com.credm.test.repo.EmailRepo;
//import com.credm.test.repo.VendorRepo;
//import com.sendgrid.Method;
//import com.sendgrid.Request;
//import com.sendgrid.Response;
//import com.sendgrid.SendGrid;
//import com.sendgrid.helpers.mail.Mail;
//import com.sendgrid.helpers.mail.objects.Content;
//import com.sendgrid.helpers.mail.objects.Email;
//
//public class SendGridServiceImpl  implements MailService{
//	
//	@Autowired
//	VendorRepo venderRepo;
//
//	@Autowired
//	EmailRepo emailRepo;
//	
//	@Value("${sendgrid.api.key}")
//	private String sendGridApiKey;
//
//	@Override
//	public ResponseMessage sendVendorEmails(List<Vendor> vendorList) {
//		try {
//			
//			for(Vendor vendor: vendorList) {
//				
//				StringBuilder Content = new StringBuilder();
//				Content = Content.append("Sending payments to vendor").append(vendor.getName()).append(" at upi ")
//						.append(vendor.getUpi());
//
//				Email from = new Email("");
//				Email toEmail = new Email(vendor.getEmail());
//				Content emailContent = new Content("text/plain", Content.toString());
//				Mail mail = new Mail(from, "Mail sub", toEmail, emailContent);
//				SendGrid sg = new SendGrid(sendGridApiKey);
//				Request request = new Request();
//				request.setMethod(Method.POST);
//				request.setEndpoint("mail/send");
//				request.setBody(mail.build());
//				Response response = sg.api(request);
//				System.out.println(response.getStatusCode());
//				System.out.println(response.getBody());
//
//				EmailModel emailSent = EmailModel.builder().email_id(vendor.getEmail())
//						.vendor(vendor.getVendorId()).build();
//
//				emailRepo.save(emailSent);
//			}
//
//			return ResponseMessage.builder().errorCode(Constants.ErrorCodes.SUCCESS).errorMessage("Success").build();
//		} catch (CustomMailException e) {
//			return ResponseMessage.builder().errorCode(Constants.ErrorCodes.ERROR)
//					.errorMessage("Error while Sending Email").build();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseMessage.builder().errorCode(Constants.ErrorCodes.ERROR)
//					.errorMessage("Error while Sending Email").build();
//		}
//	}
//}
