package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int filmId;
	private String title;
	private String description;
	private short releaseYear;
	private int langId;
	private int rentDuration;
	private double rate;
	private int length;
	private List<Actor> castList;

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", langId=" + langId + ", rentDuration=" + rentDuration + ", rate=" + rate + ", length="
				+ length + ", getFilmId()=" + getFilmId() + ", getTitle()=" + getTitle() + ", getDescription()="
				+ getDescription() + ", getReleaseYear()=" + getReleaseYear() + ", getLangId()=" + getLangId()
				+ ", getRentDuration()=" + getRentDuration() + ", getRate()=" + getRate() + ", getLength()="
				+ getLength() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
//	public String toString() {
//		String output = "";
//		for (Actor actor : castList) {
//
//			output += "The actor " + actor.getFirstName() + " " + actor.getLastName() + " were in the following films: "
//					+ title + "\n";
//		}
//		return output;
//	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, filmId, langId, length, rate, releaseYear, rentDuration, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && filmId == other.filmId && langId == other.langId
				&& length == other.length && Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate)
				&& releaseYear == other.releaseYear && rentDuration == other.rentDuration
				&& Objects.equals(title, other.title);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	public int getRentDuration() {
		return rentDuration;
	}

	public void setRentDuration(int rentDuration) {
		this.rentDuration = rentDuration;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Film() {
	}

	public Film(int filmId2, String title2, String desc, short releaseYear, int langId, int rentDur, double rate,
			int length, double repCost, String rating, String features, List<Actor> castList) {
		// TODO Auto-generated constructor stub
	}
	public Film(int filmId2, String title2, String desc, short releaseYear, int langId, int rentDur, double rate,
			int length, double repCost, String rating, String features) {
		// TODO Auto-generated constructor stub
	}

}
