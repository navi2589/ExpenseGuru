package com.expenceguru.entites;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id", nullable = false, unique = true)
	private Long personId;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="mname")
	private String mname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name = "gender_id")
	private Long genderId;
	
	@Column(name = "prefix_id")
	private Long prefoxId;
	
	@Column(name = "isDeleted")
	private Boolean isDeleted;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="gender_id", insertable=false, updatable=false)
	private Mlov gender;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="prefix_id", insertable=false, updatable=false)
	private Mlov prefix;
	
	@CreatedBy
    @Column(name ="created_by", updatable = false)
    private Long createdBy;

    @CreatedDate
    @Column(name ="created", updatable = false)
    private LocalDateTime created;

    @LastModifiedBy
    @Column(name ="modified_by")
    private Long modifiedBy;

    @LastModifiedDate
    @Column(name ="modified")
    private LocalDateTime modified;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
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

	public Mlov getGender() {
		return gender;
	}

	public void setGender(Mlov gender) {
		this.gender = gender;
	}

	public Mlov getPrefix() {
		return prefix;
	}

	public void setPrefix(Mlov prefix) {
		this.prefix = prefix;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public Long getPrefoxId() {
		return prefoxId;
	}

	public void setPrefoxId(Long prefoxId) {
		this.prefoxId = prefoxId;
	}	

}
