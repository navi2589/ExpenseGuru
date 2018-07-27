package com.taxconsultant.entites;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "mlov_type")
public class MlovType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "mlov_type_id")
	private Long mlovTypeId;
	
	@Column(name = "value")
	private String value;

	private Boolean isDeleted;
	
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

	public Long getMlovTypeId() {
		return mlovTypeId;
	}

	public void setMlovTypeId(Long mlovTypeId) {
		this.mlovTypeId = mlovTypeId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
