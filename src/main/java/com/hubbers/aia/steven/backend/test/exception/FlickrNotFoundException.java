package com.hubbers.aia.steven.backend.test.exception;

public class FlickrNotFoundException extends RuntimeException {
	
	public FlickrNotFoundException() {
		super("Could not retrieve any data base on parameter given");
	}
}
