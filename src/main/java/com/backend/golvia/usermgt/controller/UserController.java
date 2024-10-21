package com.backend.golvia.usermgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.golvia.usermgt.entities.User;
import com.backend.golvia.usermgt.models.UpdateProfileTypeRequest;
import com.backend.golvia.usermgt.models.UserInfo;

import com.backend.golvia.usermgt.services.UserService;
import com.backend.golvia.usermgt.utils.ResponseUtil;


@RestController
@RequestMapping("/api/users")
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
