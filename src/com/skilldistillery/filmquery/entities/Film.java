package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int id;
	private String title;
	private String description;
	private Integer releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private Integer length;
	private Double replacementCost;
	private String rating;
	private String specialFeatures;
	private String language;
	private List<Actor> castList;

//	public String toString() {
//		String output = "";
//		for (Actor actor : castList) {
//
//			output += "The actor " + actor.getFirstName() + " " + actor.getLastName() + " were in the following films: "
//					+ title + "\n";
//		}
//		return output;
//	}

	public Film() {
	}

	public Film(int filmId2, String title2, String desc, Integer releaseYear, int langId, int rentDur, Double rate,
			int length, double repCost, String rating, String features) {
		this.id = filmId2;
		this.title = title2;
		this.description = desc;
		this.releaseYear = releaseYear;
		this.languageId = langId;
		this.rentalDuration = rentDur;
		this.rentalRate = rate;
		this.length = length;
		this.replacementCost = repCost;
		this.rating = rating;
		this.specialFeatures = features;
	}

	@Override
	// MOVIE TITLE, YEAR, RATING, DESCRIPTION, LANGUAGE
	public String toString() {
		return "\nMovie title: " +title + "|| year of movie: "+ releaseYear + "|| movie rating: " + rating + "\n" +"-----description of movie:" +description + "\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(Double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Actor> getCastList() {
		return castList;
	}

	public void setCastList(List<Actor> castList) {
		this.castList = castList;
	}

}
