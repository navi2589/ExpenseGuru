package com.expenceguru.pojo;


public class PersonContactPojo {

	private long personContactId;
	private String contact;
	private long contactTypeId;
	private boolean isDeleted;
	private long personId;
	
	public long getPersonContactId() {
		return personContactId;
	}
	public void setPersonContactId(long personContactId) {
		this.personContactId = personContactId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public long getContactTypeId() {
		return contactTypeId;
	}
	public void setContactTypeId(long contactTypeId) {
		this.contactTypeId = contactTypeId;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	
	
}
