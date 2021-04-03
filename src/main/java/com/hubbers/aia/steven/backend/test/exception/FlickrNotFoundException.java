package com.hubbers.aia.steven.backend.test.exception;

import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class FlickrNotFoundException extends RuntimeException {
	
	public FlickrNotFoundException(Long id) {
		super("Could not found any data base on author id: " + id);
	}
	
	public FlickrNotFoundException(String tags) {
		super("Could not found any data base on tags: " + tags);
	}
	
	public FlickrNotFoundException(LocalDateTime date, String issueDateType) {
		super("Could not found any data base on " + issueDateType + ": " + date);
	}
}
