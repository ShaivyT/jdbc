package com.sat.model;

public class Phone {
	
	public Phone() {
		super();
	}
	public Phone(String id, String phone, String primary) {
		super();
		this.id = id;
		this.phone = phone;
		this.primary = primary;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", phone=" + phone + ", primary=" + primary + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
	}
	private String id;
	private String phone;
	private String primary;
}
