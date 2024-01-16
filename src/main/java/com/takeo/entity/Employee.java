package com.takeo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="employees_rest_api")
public class Employee {
	@Id
	@Column(name="eid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eid;
	
	@Column(name="fname")
	private String fName;
	
	@Column(name="lname")
	private String lName;
	
	@Column(name="email")
	private String email;

	@Column(name="passnum")
	private String passportNum;
}
