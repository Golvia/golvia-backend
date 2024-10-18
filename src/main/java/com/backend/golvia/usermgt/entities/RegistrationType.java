package com.backend.golvia.usermgt.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



public class RegistrationType {
	
	
	
	    private Long id;

	    
	    public RegistrationType() {}

		public RegistrationType(String name, String iconurl) {
			super();
			this.name = name;
			this.iconurl = iconurl;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getIconurl() {
			return iconurl;
		}


		public void setIconurl(String iconurl) {
			this.iconurl = iconurl;
		}

		
	    private String name;

	   
	  
	    private String iconurl;

}
