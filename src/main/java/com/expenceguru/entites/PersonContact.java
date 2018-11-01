package com.expenceguru.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "person_contact")
public class PersonContact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "person_contact_id", nullable = false, unique = true)
	private long personContactId;
	
	@Column(name = "contact", nullable = false)
	private String contact;
	
	@Column(name = "contact_type_id")
	private long contactTypeId;
	
	@Column(name = "person_id")
	private long personId;
	
	@Column(name = "isDeleted")
	private Boolean isDeleted;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "contact_type_id", insertable = false, updatable = false)
	private Mlov contactType;
	
	
	public PersonContact(long personContactId, String contact, long contactTypeId, boolean isDeleted, long personId) {
		super();
		this.personContactId = personContactId;
		this.contact = contact;
		this.contactTypeId = contactTypeId;
		this.isDeleted = isDeleted;
		this.personId = personId;
	}
	
	public PersonContact() {};
	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId)  {
		this.personId = personId;
	}
	
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

	public Mlov getContactType() {
		return contactType;
	}

	public void setContactType(Mlov contactType) {
		this.contactType = contactType;
	}
	
}
