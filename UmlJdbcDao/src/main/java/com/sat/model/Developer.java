package com.sat.model;

import com.sat.model.Person;

public class Developer extends Person {
	
	public Developer() {
		super();
	}

	public Developer(int id, String firstname,String lastname,String username,String password,String email,String dob,String developerKey) {
		super(id,firstname, lastname, username, password, email, dob);
		this.developerKey = developerKey;
	}

	

	public Developer(String firstName, String lastName, String username, String password, String email, String developerKey) {
		super(firstName, lastName, username, password, email);
		this.developerKey = developerKey;
	}

	@Override
	public String toString() {
		return "Developer [developerKey=" + developerKey + "]";
	}
	
	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}



	private String developerKey;	
}
