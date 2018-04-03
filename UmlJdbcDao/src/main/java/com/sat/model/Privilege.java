package com.sat.model;

public class Privilege{
	
	public Privilege() {
		super();
	}
	public Privilege(int id, int privilegeId, int developerId, int websiteId) {
		super();
		this.id = id;
		this.privilegeId = privilegeId;
		this.developerId = developerId;
		this.websiteId = websiteId;
	}
	@Override
	public String toString() {
		return "Privilege [id=" + id + ", privilegeId=" + privilegeId + ", developerId=" + developerId + ", websiteId="
				+ websiteId + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	public int getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}
	private int id;
	private int privilegeId;
	private int developerId;
	private int websiteId;
	
}
