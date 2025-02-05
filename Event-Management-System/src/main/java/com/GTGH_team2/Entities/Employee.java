package com.GTGH_team2.Entities;


public class Employee {
	private Integer id; //id of the employee
	private String name; //name of the employee
	private String surname; //surname of the employee
	private String email; //email of the employee
	
	// Constructor
	public Employee(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
		
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


	

}