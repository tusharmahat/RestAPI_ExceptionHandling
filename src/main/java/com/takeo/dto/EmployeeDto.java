package com.takeo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmployeeDto {

	private Long eid;

	@NotNull
	@Size(min = 2, message = "First name should have at least 2 characters")
	@JsonProperty("fname")
	private String fName;

	@JsonProperty("lname")
	@NotNull
	@Size(min = 2, message = "Last name should have at least 2 characters")
	private String lName;

	@JsonProperty("email")
	@Email
	@NotBlank
	@Size(min = 6, message = "Email should have at least 6 characters")
	private String email;

	@JsonProperty("pnum")
	@NotNull
	@NotBlank
	@Size(min = 6, message = "Passport Number should have at least 6 characters")
	private String passportNum;

}
