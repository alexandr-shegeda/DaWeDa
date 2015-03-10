package com.daweda.services.model;

public class UserInfo {

	private long id;
	private String email;
	private boolean isActivated;
	private String token;
	
	public UserInfo(long id, String email, boolean isActivated,
			String token) {
		this.id = id;
		this.email = email;
		this.isActivated = isActivated;
		this.token = token;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActivated() {
		return isActivated;
	}
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
