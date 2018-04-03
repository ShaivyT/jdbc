package com.sat.model;

import java.util.List;

public class Website {
	
	
	
	public Website() {
		super();
	}
	
	public Website(String name, String description, String visits) {
		super();
		this.name = name;
		this.description = description;
		this.visits = visits;
	}
	
	
	public Website(int id, List<Page> pages, String name, String description, String created, String updated,
			String visits, int developerId) {
		super();
		this.id = id;
		this.pages = pages;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.developerId = developerId;
	}
	

	public Website(int id,  String name, String description, String created, String updated, String visits, int developerId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.developerId = developerId;
	}
	
	@Override
	public String toString() {
		return "Website [id=" + id + ", pages=" + pages + ", name=" + name + ", description=" + description
				+ ", created=" + created + ", updated=" + updated + ", visits=" + visits + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Page> getPages() {
		return pages;
	}
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getVisits() {
		return visits;
	}
	public void setVisits(String visits) {
		this.visits = visits;
	}
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	

	private int id;
	private List<Page> pages;
	private String name;
	private String description;
	private String created;
	private String updated;
	private String visits;
	private int developerId;
	
}
