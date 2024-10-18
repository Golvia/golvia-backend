package com.backend.golvia.usermgt.services;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.golvia.usermgt.entities.OtpDetails;
import com.backend.golvia.usermgt.models.EmailRequest;
import com.backend.golvia.usermgt.models.MailerSendRequest;
import com.backend.golvia.usermgt.repositories.OtpRepository;

@Service
public class OtpService {

    private static final int EXPIRY_DURATION_MINUTES = 5;
   
   
    @Autowired
    OtpRepository otpRepository;

    @Autowired
    private ApiService apiService;
    
    
  

    public void generateAndSendOtp(String email) {
        String otp = generateOtp();
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(EXPIRY_DURATION_MINUTES);
        
        OtpDetails otpdetails = new OtpDetails(otp,email,expiryTime);
        
        otpRepository.save(otpdetails);
        
        EmailRequest req = formMailRequest(email,otp);
        
        apiService.sendPostRequest(req);

      
    }
    
    
    private EmailRequest formMailRequest(String email, String otp) {
    	
    	
//    	MailerSendRequest req = new MailerSendRequest();
//    	req.setSubject("Golvia : Your sports platform");
//    	req.setText("Your OTP is :"+ otp);
//    	req.setHtml("");
//    	
//    	HashMap<String, String> receiver = new HashMap<>();
//    	receiver.put("email", email);
//    	
//    	HashMap<String, String> sender = new HashMap<>();
//    	sender.put("email", "contact@gol-via.com");
//    	
//    	ArrayList<Object> to = new ArrayList<>();
//    	
//    	to.add(receiver);
//    	
//    	req.setFrom(sender);
//    	req.setTo(to);
    	
    	//
    	
    	 // Create payload
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setFrom(new EmailRequest.EmailAddress("contact@gol-via.com"));
        emailRequest.setTo(Collections.singletonList(new EmailRequest.EmailAddress(email)));
        emailRequest.setSubject("Golvia: Your OTP!");
        emailRequest.setText("Your OTP is : "+ otp);
        emailRequest.setHtml("");  // If you want to send HTML, modify this
    	
    	
    	
    	return emailRequest;
    }

    private String generateOtp() {
        int otp = new SecureRandom().nextInt(900000) + 100000; // ensures 6 digits
     
        return String.valueOf(otp);
    }

    public boolean validateOtp(String email, String otp) {
        OtpDetails otpDetails = otpRepository.findByEmailAndOtp(email, otp);

        if (otpDetails == null || otpDetails.isExpired()) {
        	
            return false; // Invalid or expired OTP
        }

        return true;
    }
}

