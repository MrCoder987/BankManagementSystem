package com.crimsonlogic.model;

public class User {
	private int userId;
	private String userName;
	private String userPassword;
	private String accNumber;
	private String accountType;

	public User() {
	}

	public User(int userId, String userName, String userPassword, String accNumber, String accountType) {
		//super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.accNumber = accNumber;
		this.accountType = accountType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
