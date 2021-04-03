package com.hubbers.aia.steven.backend.test.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Media {
	
	private Long mediaId;
	private String image;
	private Items items;
	
	public Media() {
		
	}
	
	@Id
	@GeneratedValue
	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
}
