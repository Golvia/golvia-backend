package com.backend.golvia.usermgt.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.backend.golvia.usermgt.utils.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Component
public class RequestInterceptor implements HandlerInterceptor {
	
	
	
	
	
	 private final JwtUtil jwtUtil;
	 
	 
	 public RequestInterceptor(JwtUtil jwtUtil) {
	    	
	        this.jwtUtil = jwtUtil;
	    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Logic to execute before the request reaches the controller
    	 String bearerToken = request.getHeader("Authorization");
    	 String token = null;
         if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
             System.out.println(bearerToken.substring(7)); // Extract JWT token from header
             token = bearerToken.substring(7);
             System.out.println("############# DO NOT ENTER ####################"); 
             System.out.println("====================YYYYYYYYYY EXTRACT EMAIL from Interceptor YYYYYYYYY================");
         	 System.out.println(jwtUtil.extractUsername(token));
         	 System.out.println("====================YYYYYYYYYY EXTRACT Expiration from Interceptor YYYYYYYYY================");
          	 System.out.println(jwtUtil.extractExpiration(token));
             return true;
             
         }
        return false; // Continue the request to the controller
    }

  
}

