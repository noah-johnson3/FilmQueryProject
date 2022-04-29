package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Actor {

	private String FirstName;
	private String LastName;
	private int id;
	private List<Film> films;

	public Actor() {

	}

	public Actor(String firstName, String lastName, int id, List<Film> films) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.id = id;
		this.films = films;
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

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Actor [FirstName=" + FirstName + ", LastName=" + LastName + ", id=" + id + ", films=" + films
				+ ", getFilms()=" + getFilms() + super.toString() + "]";
	}

}
