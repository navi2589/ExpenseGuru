package com.expenceguru.pojo;

public class UserPojo {
	
	private Long userId;
	private String userName;
	private String password;
	private PersonPojo person;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
