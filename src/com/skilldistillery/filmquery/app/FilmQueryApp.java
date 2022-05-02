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

//		startUserInterface();
		userMenu();
		input.close();
	}

	private void startUserInterface() {
		int userChoice = 0;
		do {
			userMenu();
//			userChoice = input.nextInt();
//			input.nextLine();
//			menuSwitch(userChoice);

		} while (userChoice != 3);

		startUserInterface();

	}

	private void userMenu() {

		boolean keepGoing = true;
		System.out.println("Hello! Welcome to my first SQL Project Please selct from the following menu");
		System.out.println("*******************************************");
		System.out.println("* 1. Look up Film by ID                   *");
		System.out.println("* 2. Look up a film by a search keyword   *");
		System.out.println("* 3. Exit Application                     *");
		System.out.println("*******************************************");
		int userChoice = input.nextInt();
		input.nextLine();

		while (keepGoing) {
			switch (userChoice) {
			case 1:
				subMenuFilmId();
				keepGoing = true;
				break;
			case 2:
				subMenuKeyWord();
				System.out.println("Going back to main menu please hold");
				System.out.println("...");
				System.out.println("...");
				System.out.println("...");
				userChoice = 0;
				break;
			case 3:
				System.out.println("Goodbye!");
				keepGoing = false;
				break;
			}

		}
	}

	private void subMenuFilmId() {
		boolean keepGoing = true;
		System.out.println("Enter 0 for the Films ID to exit");
		while (keepGoing) {
			System.out.println("Please enter the films ID: ");
			int userChoice = input.nextInt();
//			input.nextLine();
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
	}

	private void subMenuKeyWord() {

		boolean keepGoing = true;
		while (keepGoing) {

			System.out.println(
					"Please enter 0 to quit" + "\n" + "Please enter a keyword to run through the database of films.");
			String userChoice = input.nextLine();
			System.out.println(db.keyWordFilmList(userChoice));
			int userQuit = input.nextInt();
			input.nextLine();
			if (userQuit == 0) {
				keepGoing = false;
			}
		}

	}

	private void menuSwitch(int userSelection) {
	}
}
//		boolean keepGoing = true;
//		
//		while (keepGoing) {
//			switch (userSelection) {
//			case 1:
//				subMenuFilmId();
//				keepGoing = false;
//				userChoice = 0;
//				break;
//			case 2:
//				subMenuKeyWord();
//				System.out.println("Going back to main menu please hold");
//				System.out.println("...");
//				System.out.println("...");
//				System.out.println("...");
//				userChoice = 0;
//				userMenu();
//				break;
//			case 3:
//				System.out.println("Goodbye!");
//				keepGoing = false;
//				break;
//			default:
//				System.out.println("Invalid selection please try again");
//				userSelection = input.nextInt();
//				input.nextLine();
//				break;
//			}
//
//		}
//	}
