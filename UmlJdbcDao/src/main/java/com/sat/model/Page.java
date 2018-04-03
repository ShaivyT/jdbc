package com.sat.model;

public class Page {
	
	public Page() {
		super();
	}
	
	public Page(String title) {
		super();
		this.title = title;
	}
	
	public Page(String title, String description, String views) {
		super();
		this.title = title;
		this.description = description;
		this.views = views;
	}
	
	public Page(int id, String title, String description, String created, String updated, String views, int websiteId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
		this.websiteId = websiteId;
	}
	@Override
	public String toString() {
		return "Page [id=" + id + ", title=" + title + ", description=" + description + ", created=" + created
				+ ", updated=" + updated + ", views=" + views + ", websiteId=" + websiteId + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getViews() {
		return views;
	}
	public void setViews(String views) {
		this.views = views;
	}
	public int getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}
	private int id;
	private String title;
	private String description;
	private String created;
	private String updated;
	private String views;
	private int websiteId;
}


