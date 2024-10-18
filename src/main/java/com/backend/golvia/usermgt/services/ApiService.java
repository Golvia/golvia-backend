package com.backend.golvia.usermgt.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.golvia.usermgt.models.ApiResponse;
import com.backend.golvia.usermgt.models.EmailRequest;
import com.backend.golvia.usermgt.models.MailerSendRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

@Service
public class ApiService {

    private final RestTemplate restTemplate;
    
    @Value("${mailersend.authorization}")
    private String SENDER_TOKEN;
    
    
    @Value("${mailersend.url}")
    private String MAILERSEND_URL;
    //

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object sendPostRequest(EmailRequest req) {
    	
    	
    	System.out.println("**************** inside  sendPostRequest function *****************");
         
        // Set the headers
        HttpHeaders headers = new HttpHeaders();
      
        headers.set("Content-Type", "application/json");
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.set("Authorization","Bearer " + SENDER_TOKEN);
        

        // Create the request body
        HttpEntity<EmailRequest> requestEntity = new HttpEntity<>(req, headers);
        
        System.out.println("**************** printing mailersend requestEntity *****************");
        System.out.println(req);
        System.out.println(requestEntity);
        
        ResponseEntity<String> response = null;
        
        try {
            response = restTemplate.exchange(MAILERSEND_URL, HttpMethod.POST, requestEntity, String.class);
            
            System.out.println("**************** printing mailersend response after trial *****************!");
            System.out.println(response);

            // Check response status
            if (response.getStatusCode() == HttpStatus.ACCEPTED) {
                System.out.println("Email sent successfully!");
            } else {
                System.out.println("Failed to send email. Status code: " + response.getStatusCode());
            }
        } catch (Exception e) {
           
            System.out.println(e);
        }
        
        System.out.println("**************** printing mailersend body *****************");
        System.out.println(response);

        // Return the response body
        return response;
    }
}

