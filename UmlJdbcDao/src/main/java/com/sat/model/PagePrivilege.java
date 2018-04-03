package com.sat.model;

import com.sat.model.Privilege;

public class PagePrivilege {
	
	@Override
	public String toString() {
		return "PagePrivilege [id=" + id + ", privilege=" + privilege + "]";
	}
	public PagePrivilege() {
		super();
	}
	public PagePrivilege(String id, Privilege privilege) {
		super();
		this.id = id;
		this.privilege = privilege;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Privilege getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
	private String id;
	private Privilege privilege;
}
