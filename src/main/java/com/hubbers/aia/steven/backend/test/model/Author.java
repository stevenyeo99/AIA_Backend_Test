package com.hubbers.aia.steven.backend.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String uri;
	private String flickrNsid;
	private String flickrBuddyIcon;

	public Author() {
		
	}
	
	public Author(String name, String uri, String flickrNsid, String flickBuddyIcon) {
		this.name = name;
		this.uri = uri;
		this.flickrNsid = flickrNsid;
		this.flickrBuddyIcon = flickBuddyIcon;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getFlickrNsid() {
		return flickrNsid;
	}

	public void setFlickrNsid(String flickrNsid) {
		this.flickrNsid = flickrNsid;
	}

	public String getFlickrBuddyIcon() {
		return flickrBuddyIcon;
	}

	public void setFlickrBuddyIcon(String flickrBuddyIcon) {
		this.flickrBuddyIcon = flickrBuddyIcon;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", uri=" + uri + ", flickrNsid=" + flickrNsid
				+ ", flickrBuddyIcon=" + flickrBuddyIcon + "]";
	}
}
