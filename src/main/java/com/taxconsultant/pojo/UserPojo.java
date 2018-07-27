package com.taxconsultant.pojo;

public class UserPojo {
	
	private Long userId;
	private Long accountId;
	private String userName;
	private String password;
	private PersonPojo person;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PersonPojo getPerson() {
		return person;
	}

	public void setPerson(PersonPojo person) {
		this.person = person;
	}
	

}
