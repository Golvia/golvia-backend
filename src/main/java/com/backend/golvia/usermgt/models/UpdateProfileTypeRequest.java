package com.backend.golvia.usermgt.models;

import com.backend.golvia.usermgt.entities.User.ProfileType;

public class UpdateProfileTypeRequest {
	
	
	    private String email;

	    private ProfileType profileType;
	    
	    private String sportType;
	    
	    private String teamName;

		public String getEmail() {
			return email;
		}


		@Override
		public String toString() {
			return "UpdateProfileTypeRequest [email=" + email + ", profileType=" + profileType + ", sportType="
					+ sportType + ", teamName=" + teamName + "]";
		}


		public String getSportType() {
			return sportType;
		}


		public void setSportType(String sportType) {
			this.sportType = sportType;
		}


		public String getTeamName() {
			return teamName;
		}


		public void setTeamName(String teamName) {
			this.teamName = teamName;
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
