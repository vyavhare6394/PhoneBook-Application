package com.ankush.model;

import javax.persistence.Column;

import lombok.Data;

@Data
public class Contact {

	private Integer id;
	
	private String contactName;
	
	private String contactEmail;
	
	private String contactPhone;
	
	
	private String createDate;
	

	private String updateDate;
	
	
	
	
	
	
}
