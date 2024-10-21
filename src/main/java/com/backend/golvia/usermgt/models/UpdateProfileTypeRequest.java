package com.backend.golvia.usermgt.models;

import com.backend.golvia.usermgt.entities.User.ProfileType;

public class UpdateProfileTypeRequest {
	
	
	    private String email;

	    private ProfileType profileType;

		public String getEmail() {
			return email;
		}

		@Override
		public String toString() {
			return "UpdateProfileTypeRequest [email=" + email + ", profileType=" + profileType + "]";
		}

		public UpdateProfileTypeRequest(String email, ProfileType profileType) {
			super();
			this.email = email;
			this.profileType = profileType;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public ProfileType getProfileType() {
			return profileType;
		}

		public void setProfileType(ProfileType profileType) {
			this.profileType = profileType;
		}
	    
	    
	    

}
