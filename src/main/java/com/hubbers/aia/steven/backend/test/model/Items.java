package com.hubbers.aia.steven.backend.test.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Items {

	private Long itemId;
	private String title;
	private String link;
	private Media media;
	private ZonedDateTime dateTaken;
	private String description;
	private LocalDateTime published;
	private String author;
	private String authorId;
	private String tags;
	
	public Items() {
		
	}
	
	public Items(String title, String link, Media media, ZonedDateTime dateTaken, String description, LocalDateTime published, String author,
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

	@JsonIgnore
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
	
	@OneToOne(mappedBy = "items", cascade = CascadeType.ALL)
	public Media getMedia() {
		return media;
	}

	@JsonProperty("media")
	public void setMedia(Media media) {
		this.media = media;
	}

	public ZonedDateTime getDateTaken() {
		return dateTaken;
	}

	@JsonProperty("date_taken")
	public void setDateTaken(ZonedDateTime dateTaken) {
		this.dateTaken = dateTaken;
	}

	@Type(type="text")
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

	@JsonProperty("author_id")
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	@Type(type="text")
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
