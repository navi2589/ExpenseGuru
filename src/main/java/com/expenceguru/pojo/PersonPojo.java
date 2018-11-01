package com.expenceguru.pojo;

import java.util.List;

public class PersonPojo {
	
	private long personId;
	private String fname;
	private String mname;
	private String lname;
	private long prefixId;
	private long genderId;
	private List<PersonContactPojo> personContacts;
	
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Long getPrefixId() {
		return prefixId;
	}
	public void setPrefixId(long prefixId) {
		this.prefixId = prefixId;
	}
	public Long getGenderId() {
		return genderId;
	}
	public List<PersonContactPojo> getPersonContacts() {
		return personContacts;
	}
	public void setPersonContacts(List<PersonContactPojo> personContacts) {
		this.personContacts = personContacts;
	}
	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}
	
	
	

}
