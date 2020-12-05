package com.quinnox.sbiloans.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="formstatus")
public class FormStatus {
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;

	
	@Column(name="applicationId")
	private int applicationId;
	
	@Column(name="status")
	private String status;
	
}
