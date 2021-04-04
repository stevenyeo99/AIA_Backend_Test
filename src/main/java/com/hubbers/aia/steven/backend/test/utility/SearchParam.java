package com.hubbers.aia.steven.backend.test.utility;

import java.time.LocalDate;

public class SearchParam {
	
	private String id;
	private String ids;
	private String tags;
	private String tagmode;
	private LocalDate publishDate;
	private LocalDate dateTaken;
	
	public SearchParam() {
		
	}
	
	public SearchParam(String id, String ids, String tags, String tagmode, LocalDate publishDate, LocalDate dateTaken) {
		this.id = id;
		this.ids = ids;
		this.tags = tags;
		this.tagmode = tagmode;
		this.publishDate = publishDate;
		this.dateTaken = dateTaken;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTagmode() {
		return tagmode;
	}

	public void setTagmode(String tagmode) {
		this.tagmode = tagmode;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public LocalDate getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(LocalDate dateTaken) {
		this.dateTaken = dateTaken;
	}
}
