package com.hubbers.aia.steven.backend.test.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hubbers.aia.steven.backend.test.exception.FlickrNotFoundException;

@ControllerAdvice
public class FlickrNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(FlickrNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String flickrNotFoundHandler(FlickrNotFoundException exception) {
		
		return exception.getMessage();
	}
}
