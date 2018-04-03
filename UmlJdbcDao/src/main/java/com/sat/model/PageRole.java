package com.sat.model;

import com.sat.model.Role;

public class PageRole {
	
	
	
	public PageRole() {
		super();
	}
	public PageRole(String id, Role role) {
		super();
		this.id = id;
		this.role = role;
	}
	@Override
	public String toString() {
		return "PageRole [id=" + id + ", role=" + role + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	private String id;
	private Role role;
}
