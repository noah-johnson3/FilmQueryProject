package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		List<Actor> actors = film.getCastList();
		for (Actor actor : actors) {
			System.out.println(actor);
		}
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);
		Film film = db.findFilmById(1);
		System.out.println(film);
		List<Actor> actorList = db.findActorsByFilmId(1);
		for (Actor actor : actorList) {
			System.out.println(actor);
		}
		input.close();
	}

	private void startUserInterface(Scanner input) {
	
	}
}

// USER STORY 3
// SAY WHAT WORD DO YOU 
//  select film.title, film.description FROM film
// WHERE title LIKE '%amp%' OR description LIKE '%amp%';
//
//			--....(sql code) WHERE title like? OR description LIKE ?;
// pstmt.setString(1, "%" + searchWord + "%");
// pstmt.setString(2, "%" + searchWord + "%");
// searchWord = paramter in method)
