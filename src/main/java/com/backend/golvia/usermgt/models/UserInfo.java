package com.backend.golvia.usermgt.models;

import com.backend.golvia.usermgt.entities.Athlete;
import com.backend.golvia.usermgt.entities.User;

public class UserInfo {
	
	
	
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	private User user =null;
	private Athlete profile=null;;
	public UserInfo(User user, Athlete profile) {
		super();
		this.user = user;
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "UserInfo [user=" + user + ", profile=" + profile + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Athlete getProfile() {
		return profile;
	}
	public void setProfile(Athlete profile) {
		this.profile = profile;
	}
	
	
	
	

}
