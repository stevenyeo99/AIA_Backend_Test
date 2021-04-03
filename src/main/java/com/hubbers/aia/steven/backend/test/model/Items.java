package com.hubbers.aia.steven.backend.test.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Items {

	private Long itemId;
	private String title;
	private String link;
	private Media media;
	private LocalDateTime dateTaken;
	private String description;
	private LocalDateTime published;
	private String author;
	private String authorId;
	private String tags;
	
	public Items() {
		
	}
	
	public Items(String title, String link, Media media, LocalDateTime dateTaken, String description, LocalDateTime published, String author,
			String authorId, String tags) {
		this.title = title;
		this.link = link;
		this.media = media;
		this.dateTaken = dateTaken;
		this.description = description;
		this.published = published;
		this.author = author;
		this.authorId = authorId;
		this.tags = tags;
	}

	@Id
	@GeneratedValue
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	@OneToOne(mappedBy = "items")
	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public LocalDateTime getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(LocalDateTime dateTaken) {
		this.dateTaken = dateTaken;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getPublished() {
		return published;
	}

	public void setPublished(LocalDateTime published) {
		this.published = published;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
