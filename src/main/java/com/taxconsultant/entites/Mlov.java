package com.taxconsultant.entites;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name= "mlov")
public class Mlov {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "mlov_id")
	private Long mlovId;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "mlov_type_id")
	private Long mlovTypeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mlov_type_id" ,insertable = false ,updatable = false)
	private MlovType mlovType;
	
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

	public Long getMlovId() {
		return mlovId;
	}

	public void setMlovId(Long mlovId) {
		this.mlovId = mlovId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getMlovTypeId() {
		return mlovTypeId;
	}

	public void setMlovTypeId(Long mlovTypeId) {
		this.mlovTypeId = mlovTypeId;
	}

	public MlovType getMlovType() {
		return mlovType;
	}

	public void setMlovType(MlovType mlovType) {
		this.mlovType = mlovType;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
	
}
