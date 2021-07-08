package com.cts.spring_learn.service.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cts.spring_learn.service.exception.CountryNotFoundException;
import com.cts.spring_learn.service.exception.EmployeeNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<Object> countryNotFoundHandler(CountryNotFoundException ex) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("timestamp", new Date());
		response.put("error", "Not Found");
		response.put("message", ex.getMessage());
		response.put("status", 404);
		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> countryNotFoundHandler(EmployeeNotFoundException ex) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("timestamp", new Date());
		response.put("error", "Not Found");
		response.put("message", ex.getMessage());
		response.put("status", 404);
		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleHttpMessageNotReadable(

			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status,

			WebRequest request) {

			Map<String, Object> body = new LinkedHashMap<>();

			body.put("timestamp", new Date());

			body.put("status", status.value());

			body.put("error", "Bad Request");

			List<String> errors = new ArrayList<String>();

			if (ex.getCause() instanceof InvalidFormatException) {

			final Throwable cause = ex.getCause() == null ? ex : ex.getCause();

			for (InvalidFormatException.Reference reference : ((InvalidFormatException) cause).getPath()) {

			body.put("message", "Incorrect format for field '" + reference.getFieldName() + "'");

			}

			}

			return new ResponseEntity<>(body, headers, status);

			}
	
	
	

}
