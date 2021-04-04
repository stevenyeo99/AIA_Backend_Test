package com.hubbers.aia.steven.backend.test.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hubbers.aia.steven.backend.test.exception.FlickrNotFoundException;
import com.hubbers.aia.steven.backend.test.utility.ResponseStatus;

@RestControllerAdvice
public class FlickrNotFoundAdvice {
	
	@ExceptionHandler(FlickrNotFoundException.class)
	public ResponseEntity<?> flickrNotFoundHandler(FlickrNotFoundException exception) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseStatus(exception.getMessage()));
	}
}
