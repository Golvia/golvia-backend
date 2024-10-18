package com.backend.golvia.usermgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.golvia.usermgt.entities.User;

import com.backend.golvia.usermgt.models.UserInfo;

import com.backend.golvia.usermgt.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	
	  @Autowired
	  private UserService userService;
	
	
	  @RequestMapping("/")
	  public String gateway_message() {
	       
	        return "This is the Backend service for Golvia .";
	  }
	
//	  
//	  @PostMapping("/getProfile")
//	    public ResponseEntity<UserInfo> subscriberProfile(@RequestBody User user) {
//		  UserInfo singleUser = userService.getUserByEmail(user.getEmail());
//	        return ResponseEntity.ok(singleUser);
//	   }
	  
	 
	  
	

	

}
