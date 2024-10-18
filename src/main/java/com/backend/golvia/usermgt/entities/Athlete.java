package com.backend.golvia.usermgt.entities;



import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



import jakarta.persistence.*;

@Entity
@Table(name = "athletes")
public class Athlete {
	
	
	    public Athlete() {
		super();
		// TODO Auto-generated constructor stub
	}


		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(nullable = false, length = 150)
	    private String country;
	    
	    @Column(nullable = true, length = 150)
	    private String address;
	    
	    @Column(nullable = false, length = 100)
	    private String date_of_birth;
	    
	    public Long getId() {
			return id;
		}


		public Athlete(Long id, String country, String address, String date_of_birth, int years_of_experience,
				String height, String weight, String biography, String current_club, String prefered_position,
				String prefered_foot, String prefered_club, User user, String email, Profession profession,
				LocalDateTime date_created, LocalDateTime date_updated) {
			super();
			this.id = id;
			this.country = country;
			this.address = address;
			this.date_of_birth = date_of_birth;
			this.years_of_experience = years_of_experience;
			this.height = height;
			this.weight = weight;
			this.biography = biography;
			this.current_club = current_club;
			this.prefered_position = prefered_position;
			this.prefered_foot = prefered_foot;
			this.prefered_club = prefered_club;
			this.email = email;
			this.profession = profession;
			this.date_created = date_created;
			this.date_updated = date_updated;
		}


		@Override
		public String toString() {
			return "Athlete [id=" + id + ", country=" + country + ", address=" + address + ", date_of_birth="
					+ date_of_birth + ", years_of_experience=" + years_of_experience + ", height=" + height
					+ ", weight=" + weight + ", biography=" + biography + ", current_club=" + current_club
					+ ", prefered_position=" + prefered_position + ", prefered_foot=" + prefered_foot
					+ ", prefered_club=" + prefered_club + ", email=" + email + ", profession="
					+ profession + ", date_created=" + date_created + ", date_updated=" + date_updated + "]";
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getDate_of_birth() {
			return date_of_birth;
		}


		public void setDate_of_birth(String date_of_birth) {
			this.date_of_birth = date_of_birth;
		}


		public int getYears_of_experience() {
			return years_of_experience;
		}


		public void setYears_of_experience(int years_of_experience) {
			this.years_of_experience = years_of_experience;
		}


		public String getHeight() {
			return height;
		}


		public void setHeight(String height) {
			this.height = height;
		}


		public String getWeight() {
			return weight;
		}


		public void setWeight(String weight) {
			this.weight = weight;
		}


		public String getBiography() {
			return biography;
		}


		public void setBiography(String biography) {
			this.biography = biography;
		}


		public String getCurrent_club() {
			return current_club;
		}


		public void setCurrent_club(String current_club) {
			this.current_club = current_club;
		}


		public String getPrefered_position() {
			return prefered_position;
		}


		public void setPrefered_position(String prefered_position) {
			this.prefered_position = prefered_position;
		}


		public String getPrefered_foot() {
			return prefered_foot;
		}


		public void setPrefered_foot(String prefered_foot) {
			this.prefered_foot = prefered_foot;
		}


		public String getPrefered_club() {
			return prefered_club;
		}


		public void setPrefered_club(String prefered_club) {
			this.prefered_club = prefered_club;
		}



		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public Profession getProfession() {
			return profession;
		}


		public void setProfession(Profession profession) {
			this.profession = profession;
		}


		public LocalDateTime getDate_created() {
			return date_created;
		}


		public void setDate_created(LocalDateTime date_created) {
			this.date_created = date_created;
		}


		public LocalDateTime getDate_updated() {
			return date_updated;
		}


		public void setDate_updated(LocalDateTime date_updated) {
			this.date_updated = date_updated;
		}


		@Column(nullable = false)
	    private int years_of_experience;
	    
	    @Column(nullable = false, length = 100)
	    private String height;
	    
	    
	    @Column(nullable = false, length = 100)
	    private String weight;
	    
	    @Column(nullable = false, length = 255)
	    private String biography;
	    
	    @Column(nullable = true, length = 200)
	    private String current_club;
	    
	    @Column(nullable = false, length = 100)
	    private String prefered_position;
	    
	    @Column(nullable = false, length = 100)
	    private String prefered_foot;
	    
	    @Column(nullable = false, length = 100)
	    private String prefered_club;
	    
	    
	    @JoinColumn(nullable = false, unique = true,  name = "email", referencedColumnName = "email")
	    private String email;
	    
	    @Enumerated(EnumType.STRING)  
	    @Column(nullable = false)
	    private Profession profession;
	    //1801610000475
	    
	    @CreationTimestamp  
	    @Column(updatable = false) 
	    private LocalDateTime date_created;
	    
	    
	    @UpdateTimestamp 
	    private LocalDateTime date_updated;
	    
	    public enum Profession {
	    	
	    	Footballer,
	    	Basketballer,
	    	Athletes

	    }
	
	

}
