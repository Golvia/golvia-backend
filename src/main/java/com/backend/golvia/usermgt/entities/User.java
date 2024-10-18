package com.backend.golvia.usermgt.entities;




import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import lombok.ToString;


@Entity
@Table(name = "users")

@ToString(exclude = "password")
@Builder
public class User {


    public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Sorry, fullname is required")
    @Column(nullable = false)
    private String fullname;

    @NotBlank(message = "Sorry, email is required")
    @Column(nullable = false, unique = true)
    private String email;
    
    
    @NotBlank(message = "Sorry, country is required")
    @Column(nullable = false)
    private String country;
    
    


    @Enumerated(EnumType.STRING)  // Stores the enum as a string (e.g., "ACTIVE", "INACTIVE")
    @Column(name = "profileType",nullable = true)
    private ProfileType profileType;

    public ProfileType getProfileType() {
		return profileType;
	}

	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}

	@NotBlank(message = "Sorry, password is required")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;
    

    
    @JsonIgnore
    @Column(nullable = false)
    private boolean active = false;
    
    @JsonIgnore
    @Column(nullable = false)
    private boolean deleted = false;
    
    
    @CreationTimestamp  
    @Column(updatable = false) 
    private LocalDateTime dateCreated;
    
    
    @UpdateTimestamp 
    private LocalDateTime dateUpdated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	


	public User(Long id, @NotBlank(message = "Sorry, fullname is required") String fullname,
			@NotBlank(message = "Sorry, email is required") String email,
			@NotBlank(message = "Sorry, country is required") String country, ProfileType profileType,
			@NotBlank(message = "Sorry, password is required") String password, boolean active, boolean deleted,
			LocalDateTime dateCreated, LocalDateTime dateUpdated) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.country = country;
		this.profileType = profileType;
		this.password = password;
		this.active = active;
		this.deleted = deleted;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}






	public enum ProfileType {
	    ATHLETES,
	    SCOUT,
	    TEAM,
	    FANBASE
	}



    

    // Getters and setters
}
