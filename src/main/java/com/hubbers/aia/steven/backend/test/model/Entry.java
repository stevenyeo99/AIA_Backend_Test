package com.hubbers.aia.steven.backend.test.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Entry {
	
	@Id
	@GeneratedValue
	private Long id;
	private String flickrId;
	private String title;
	private LocalDateTime published;
	private LocalDateTime updated;
	private LocalDateTime flickrDateTaken;
	private LocalDateTime dcTaken;
	private String displayCategories;
	private String content;
	private Author author;
	private Set<Category> categories;
	
}
