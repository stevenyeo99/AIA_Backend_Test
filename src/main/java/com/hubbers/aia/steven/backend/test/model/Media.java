package com.hubbers.aia.steven.backend.test.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Media {
	
	private Long mediaId;
	private String image;
	private Items items;
	
	public Media() {
		
	}
	
	@JsonIgnore
	@Id
	@GeneratedValue
	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	@Type(type="text")
	public String getImage() {
		return image;
	}
	
	@JsonProperty("m")
	public void setImage(String image) {
		this.image = image;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
}
