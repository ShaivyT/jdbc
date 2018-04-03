package com.sat.model;


public class Role{
	
	public Role() {
		super();
	}
	public Role(int id, int roleId, int developerId, int websiteId) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.developerId = developerId;
		this.websiteId = websiteId;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleId=" + roleId + ", developerId=" + developerId + ", websiteId=" + websiteId
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
	private int roleId;
	private int developerId;
	private int websiteId;
	
	
}

