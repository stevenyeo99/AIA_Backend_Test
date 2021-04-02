package com.hubbers.aia.steven.backend.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Link {
	
	@Id
	@GeneratedValue
	private Long id;
	private String rel;
	private String type;
	private String href;
}
