package com.onlinestore.zemoso.exception;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	
	public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request){
		Map<Object, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDate.now());
		body.put("message", ex.getMessage());
		
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
