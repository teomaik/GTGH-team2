package com.GTGH_team2.Entities;

//import java.util.ArrayList;

public class Visitor {
	private Integer id;
	private String name;
	private String surname;
	private String email;
	// private ArrayList<Reservation> reservations = new ArrayList<>();

	public Visitor(String name, String surname, String email) {
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

	@Override
	public String toString() {
		return "Visitor{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", email='"
				+ email + '\'' + '}';
	}

}
    