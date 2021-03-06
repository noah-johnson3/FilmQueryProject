package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Actor {

	private String FirstName;
	private String LastName;
	private int id;
	private List<Film> films;

	public Actor() {

	}

	public Actor(String firstName, String lastName, int id) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Actor [FirstName=" + FirstName + " LastName=" + LastName + ", id=" + id + "\n";

	}
}