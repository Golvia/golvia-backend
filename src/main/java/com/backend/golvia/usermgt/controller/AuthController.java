package com.backend.golvia.usermgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.golvia.usermgt.entities.OtpDetails;
import com.backend.golvia.usermgt.entities.User;
import com.backend.golvia.usermgt.models.UpdateProfileTypeRequest;
import com.backend.golvia.usermgt.models.UserInfo;
import com.backend.golvia.usermgt.services.OtpService;

import com.backend.golvia.usermgt.services.UserService;

import com.backend.golvia.usermgt.utils.ResponseUtil;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/auth")
public class AuthController {

	   @Autowired
	   private UserService userService;
	  
	   @Autowired
	   private OtpService otpService;
	
	   
	   
//	   @Operation(summary = "Register a new user by collecting fullname, email , country and password ", description = "Returns the stored user details")
//	    @ApiResponses(value = {
//	        @ApiResponse(responseCode = "201", description = "New user created and returned"),
//	        @ApiResponse(responseCode = "422", description = "unprocessable entity , user already exists"),
//	        @ApiResponse(responseCode = "500", description = "Internal server error")
//	    })
	  @PostMapping("/register")
	    public ResponseEntity<Object> registerUser(@RequestBody User user) {
	        User savedUser = userService.createUser(user);
	        otpService.generateAndSendOtp(user.getEmail());
	        return ResponseEntity.status(201).body(ResponseUtil.register_success(savedUser));
	   }
	  
	  
	  
	  
//	    @Operation(summary = "login by providing email  and password ", description = "Returns user jwt token to access other endpoints")
//	    @ApiResponses(value = {
//	        @ApiResponse(responseCode = "401", description = "Access Denied"),
//	        @ApiResponse(responseCode = "200", description = " user exists , but is Inactive"),
//	        @ApiResponse(responseCode = "201", description = "Successfully logged in, token generated and returned")
//	    })
	    @PostMapping("/login")
	    public ResponseEntity<Object> authentication(@RequestBody User user) {
		  
		    String token_response = userService.authentication(user);
		    if(token_response == "Denied") {
		    	
		    	return ResponseEntity.status(401).body(ResponseUtil.auth_failure("Wrong credentials"));
		    	
		    }else if(token_response == "Inactive") {
		    	
		    	otpService.generateAndSendOtp(user.getEmail());
		    	
		    	return  ResponseEntity.status(200).body(ResponseUtil.auth_activate(user.getEmail()));
		    }
		    
		    UserInfo userInfo = userService.getUserByEmail(user.getEmail());
		    
		    return  ResponseEntity.status(201).body(ResponseUtil.auth_success(token_response,userInfo));
	   }
	    
	  
	  
	  
//	    @Operation(summary = "Activate an account by validating the OTP ", description = "send email & OTP and returns token.")
//	    @ApiResponses(value = {
//	        @ApiResponse(responseCode = "401", description = "Wrong OTP"),
//	        @ApiResponse(responseCode = "201", description = "Successfully logged in, token generated and returned")
//	    })
	    @PostMapping("/validateOTP")
	    public ResponseEntity<Object> validateOTP(@RequestBody OtpDetails details) {
		  
	       String  token_response = userService.confirmOTP(details.getEmail(), details.getOtp());
           if(token_response == "wrong otp") {
		    	
		    	return ResponseEntity.status(401).body(ResponseUtil.auth_failure(token_response));
		    	
		    }
           
           UserInfo userInfo = userService.getUserByEmail(details.getEmail());
           
           return  ResponseEntity.status(201).body(ResponseUtil.auth_success(token_response,userInfo));
	   }
	    
	    
	    
	    @PostMapping("/updateProfileType")
	    public ResponseEntity<Object> updateProfileType(@RequestBody UpdateProfileTypeRequest req) {
	    	
	    	
	    	if(req == null) {
	    		
	    		return ResponseEntity.status(400).body(ResponseUtil.bad_request("bad request"));
	    	}
		  
	       boolean response = userService.updateProfileType(req.getEmail(),req.getProfileType());
	       
	       if(response) {
	    	   
	    	   return ResponseEntity.status(200).body(ResponseUtil.success(null));
	       }else {
	    	   
	    	   return ResponseEntity.status(422).body(ResponseUtil.unprocessable_request("unprocessable request"));
	    	   
	       }
	       
           
           
	   }
	    
	    
	  
	  
	  
	  
	  
	

	

}
