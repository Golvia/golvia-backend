package com.backend.golvia.usermgt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.golvia.usermgt.entities.OtpDetails;
import com.backend.golvia.usermgt.entities.User;

@Repository
public interface OtpRepository extends JpaRepository<OtpDetails, Long>{
	
	
	 OtpDetails findByEmail(String email);
	
	 @Query(value="SELECT * FROM otpdetails  WHERE email = :email AND otp = :otp",nativeQuery = true)
	 OtpDetails findByEmailAndOtp(String email, String otp);

}
