package com.backend.golvia.usermgt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.golvia.usermgt.entities.Athlete;
import com.backend.golvia.usermgt.entities.User;
import com.backend.golvia.usermgt.models.UserInfo;
import com.backend.golvia.usermgt.repositories.AthleteRepository;
import com.backend.golvia.usermgt.repositories.UserRepository;
import com.backend.golvia.usermgt.utils.JwtUtil;
import com.backend.golvia.usermgt.utils.PasswordUtil;


@Service
public class UserService {

	
    @Autowired
    private UserRepository userRepository;
    
    @Autowired 
    private AthleteRepository athleteRepository;
    
    
	@Autowired
	private OtpService otpService;
    
    
    private final JwtUtil jwtUtil;

    
    
    public UserService(JwtUtil jwtUtil) {
    	
        this.jwtUtil = jwtUtil;
    }
    

    public List<User> getAllUsers() {
    	
        return userRepository.findAll();
        
    }
    
    

    public UserInfo getUserByEmail(String email) {
    	
    	UserInfo userinfo = new UserInfo();
    	userinfo.setUser(userRepository.findByEmail(email));
    	userinfo.setProfile(athleteRepository.findByEmail(email));
    	
        return userinfo;
        
    }
    
    

    public User createUser(User user){
    	
    	user.setPassword(PasswordUtil.encodePassword(user.getPassword()));
    	
    	return userRepository.save(user);
   
    }
    
    
    public String authentication(User user) {
    	
    	
    	if(checkUser(user) ==  "Authenticated") {
    		
    		return (jwtUtil.generateToken(user.getEmail()));
    		
    	}else if(checkUser(user) ==  "Inactive") {
    		
    		return "Inactive";
    		
    	}else {
    		
    		return "Denied";
    	}
    	
    	
    	
    }
    
    
   
    
    public Athlete upgradeProfile(Athlete athlete){
    	
    	System.out.println("====================================");
    	
    	System.out.println(athlete);
        
    	return athleteRepository.save(athlete);
  
    }
    
    
    
    public String testing(String totoK) {
    	
    	 System.out.println("==================== I AM NOW IN THE CONTROLLER ================");
    	
    	return "";
    	
    }
    
    
    
    public String confirmOTP (String email, String otp) {
    	
    	String token = null;
    	
    	if(otpService.validateOtp(email, otp)) {
    		
    		User user = userRepository.findByEmail(email);
        	user.setActive(true);
        	userRepository.save(user);
        
    		token = (jwtUtil.generateToken(email));
    		
    	}else {
    		
    		token = "wrong otp";
    	}
    	
    	
    	return token;
    }
    
    
    
    
    
    
    public String checkUser(User user) {
    	
    	User db_user = userRepository.findByEmail(user.getEmail());
    	 
    
    	if (db_user == null) {return "Denied";}
    	
    	if(PasswordUtil.checkPassword(user.getPassword(), db_user.getPassword()) && db_user.isActive()==true){
    		
    		
    		return "Authenticated";
    		
    	}
    	
        if(PasswordUtil.checkPassword(user.getPassword(), db_user.getPassword()) && db_user.isActive()==false){
    		
    		
    		return "Inactive";
    		
    	}
    	
    	
    	return "Denied";
    }
    
    
    
}
