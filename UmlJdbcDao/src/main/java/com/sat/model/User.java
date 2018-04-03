package com.sat.model;

import com.sat.model.Person;

public class User extends Person {
	
	
	
	public User() {
		super();
	}
	public User(int id, String userAgreement) {
		super();
		this.id = id;
		this.userAgreement = userAgreement;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userAgreement=" + userAgreement + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserAgreement() {
		return userAgreement;
	}
	public void setUserAgreement(String userAgreement) {
		this.userAgreement = userAgreement;
	}
	private int id;
	private String userAgreement;
	
}
