package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
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

		userMenu();
		input.close();
	}



	private void userMenu() {

		boolean keepGoing = true;

		while (keepGoing) {
			System.out.println("Hello! Welcome to my first SQL Project Please selct from the following menu");
			System.out.println("*******************************************");
			System.out.println("* 1. Look up Film by ID                   *");
			System.out.println("* 2. Look up a film by a search keyword   *");
			System.out.println("* 3. Exit Application                     *");
			System.out.println("*******************************************");
			int userChoice = input.nextInt();
			input.nextLine();
			switch (userChoice) {
			case 1:
				keepGoing = subMenuFilmId();
				break;
			case 2:
				keepGoing = subMenuKeyWord();
				break;
			case 3:
				System.out.println("Goodbye!");
				keepGoing = false;
				System.exit(0);
				break;
			}
		}
	}

	private boolean subMenuFilmId() {
		boolean keepGoing = true;
		System.out.println("Enter 0 for the Films ID to exit");
		while (keepGoing) {
			System.out.println("Please enter the films ID: ");
			int userChoice = input.nextInt();
			input.nextLine();
			if (userChoice == 0) {
				userMenu();
				keepGoing = false;
				break;
			} else if (db.findFilmById(userChoice) == null) {
				System.out.println("Invalid selection try again");
				continue;
			} else {
				Film film = db.findFilmById(userChoice);
				List<Actor> actorList = db.findActorsByFilmId(userChoice);
				System.out.println(film);
				for (Actor actor : actorList) {
					System.out.println(actor);
				}
				continue;
			}
		}
		return keepGoing;
	}

	private boolean subMenuKeyWord() {

		boolean keepGoing = true;
		System.out.println("Please enter goback to quit");
		while (keepGoing) {
			System.out.println("\n" + "Please enter a keyword to run through the database of films.");
			String userChoice = input.nextLine();

			if (userChoice.equalsIgnoreCase("goback")) {
				keepGoing = false;
				continue;
			} else {
				System.out.println(db.keyWordFilmList(userChoice));
				input.nextLine();

				break;
			}

		}
		return keepGoing;
	}
}
