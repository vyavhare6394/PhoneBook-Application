package com.ankush.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name="contact_dtls")
@Data
public class ContactEntity {
	
	
	@Id
	@Column(name="contact_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="contact_name")
	private String contactName;
	
	
	@NotNull
	@Size(min=1, message="is requird")
	@Column(name="contact_email")
	private String contactEmail;
	

	@Column(name="contact_phno")
	private String contactPhone;;
	
	
	@CreationTimestamp()
	@Temporal(TemporalType.DATE)
	@Column(name="create_date",updatable = false)
	private Date createDate;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="update_date",insertable = false)
	private Date updateDate;
	
	
	

}
