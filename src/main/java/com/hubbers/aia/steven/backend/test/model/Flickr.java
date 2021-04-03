package com.hubbers.aia.steven.backend.test.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Flickr {
	
	private String title;
	private ArrayList<Items> items;
	
	public Flickr() {
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Items> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<Items> items) {
		this.items = items;
	}
}
