package com.daweda.services.model;

public class UserCredentials {

	private int userId;
	private String userAccount;
	private String emailAddress;
	private String password;
	private String language;
	private String ip;
	private String countryIp;
	
	private boolean isEmailInDb = false;
	
	public boolean getIsEmailInDb() {
		return isEmailInDb;
	}
	
	public void setIsEmailInDb(boolean bOk) {
		isEmailInDb = bOk;
	}
	
	public UserCredentials() {
		
	}


	//For creating a new instance (without userId)
	//DB generates userId  
	public UserCredentials(String userAccount, String emailAddress,
                           String password, String language, String ip, String countryIp) {
		this.userAccount = userAccount;
		this.emailAddress = emailAddress;
		this.password = password;
		this.language = language;
		this.ip = ip;
		this.countryIp = countryIp;
	}
	
	
	//For getting instance by method findByUserId (with userId)
	public UserCredentials(int userId, String userAccount, String emailAddress,
                           String password, String language, String ip, String countryIp) {
		super();
		this.userId = userId;
		this.userAccount = userAccount;
		this.emailAddress = emailAddress;
		this.password = password;
		this.language = language;
		this.ip = ip;
		this.countryIp = countryIp;
	}



	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCountryIp() {
		return countryIp;
	}
	public void setCountryIp(String countryIp) {
		this.countryIp = countryIp;
	}
	
	
}
