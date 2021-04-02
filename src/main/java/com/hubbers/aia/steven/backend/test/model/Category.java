package com.hubbers.aia.steven.backend.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	private String term;
	private String scheme;
}
