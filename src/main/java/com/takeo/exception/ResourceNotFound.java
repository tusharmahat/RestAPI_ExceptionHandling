package com.takeo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFound extends Exception{
	String message;
	public ResourceNotFound(String message) {
		super(message);
		this.message = message;
	}
}
