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
		
		startUserInterface();
		input.close();
	}

	private void startUserInterface() {
		int userChoice = 0;
		do {
			userMenu();
			userChoice = input.nextInt();
			input.nextLine();
			menuSwitch(userChoice);
		}while(userChoice != 3);
		
		startUserInterface();

		
	}

	private void userMenu() {

		System.out.println("Hello! Welcome to my first SQL Project Please selct from the following menu");
		System.out.println("*******************************************");
		System.out.println("* 1. Look up Film by ID                   *");
		System.out.println("* 2. Look up a film by a search keyword   *");
		System.out.println("* 3. Exit Application                     *");
		System.out.println("*******************************************");

	}

	private void subMenuFilmId() {
		boolean keepGoing = true;
		System.out.println("Enter 0 for the Films ID to exit");
		while (keepGoing) {
			System.out.println("Please enter the films ID: ");
			int userChoice = input.nextInt();
			input.nextLine();
			if (db.findFilmById(userChoice) == null) {
				System.out.println("Invalid selection try again");
			} else {
				Film film = db.findFilmById(userChoice);
				List<Actor> actorList = db.findActorsByFilmId(userChoice);
				System.out.println(film);
				for (Actor actor : actorList) {
					System.out.println(actor);
				}
			}
			if (userChoice == 0) {
				keepGoing = false;
			}
		}
	}

	private void subMenuKeyWord() {

		boolean keepGoing = true;
		while (true) {

			System.out.println("Please enter quit to quit" + "\n"
					+ "Please enter a keyword to run through the database of films.");
			String userChoice = input.nextLine();
			db.keyWordFilmList(userChoice);
		}

	}
	private void menuSwitch(int userSelection) {
		boolean keepGoing = true;
		while (keepGoing) {
			switch (userSelection) {
			case 1:
				subMenuFilmId();
				keepGoing = false;
				break;
			case 2:
				subMenuKeyWord();
			case 3:
				System.out.println("Goodbye!");
				keepGoing = false;
			default:
				System.out.println("Invalid selection please try again");
				userSelection = input.nextInt();
				input.nextLine();
				break;
			}

		}
	}
}

