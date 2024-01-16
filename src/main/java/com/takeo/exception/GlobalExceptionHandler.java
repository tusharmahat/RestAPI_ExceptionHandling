package com.takeo.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFound ex, WebRequest req) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalException(Exception ex, WebRequest req) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<?> handleMethodArgNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest req) {
		System.out.println("working");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Bad Request", req.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
