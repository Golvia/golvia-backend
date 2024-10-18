package com.backend.golvia.usermgt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.golvia.usermgt.entities.Athlete;
import com.backend.golvia.usermgt.entities.User;


@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long>{
	
	
	Athlete findByEmail(String email);

}
