package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.iomanager.common.*;

public class FilmQueryApp {
	private static IOManager ioManager = new SystemIOManager();
	private static DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		launch();
	}

	// private void test() {
	// Film film = db.getFilmById(1);
	// System.out.println(film);
	// Actor actor = db.getActorById(1);
	// System.out.println(actor);
	// }

	private static void launch() {
		FilmQueryApp app = new FilmQueryApp();
		boolean keepLooking = true;
		// app.test();
		ioManager.print(new WelcomeMessage());
		while (keepLooking == true) {
			ioManager.print(new DisplayMenu());
			String theInput = ioManager.getUserInput(new Text(""));
			try {
				if (theInput.equals("1")) {
					ioManager.print(
							new TextWithNewLine("Enter the numerical ID of the film you would like to look up."));
					String filmIdInput = ioManager.getUserInput(new Text(""));
					int numericalId = Integer.parseInt(filmIdInput);
					Film filmToReturn = db.getFilmById(numericalId);
					ioManager.print(new TextWithNewLine("\n" + filmToReturn.toString()));
				} else if (theInput.equals("2")) {
					ioManager.print(new TextWithNewLine(
							"Enter a keyword to cross reference against film titles and descriptions."));
					String keywordInput = ioManager.getUserInput(new Text(""));
					Film filmToReturn = db.getFilmByKeyword(keywordInput);
				} else if (theInput.equals("3")) {
					ioManager.print(new TextWithNewLine("Goodbye!"));
					keepLooking = false;
				} else {
					throw new InputMismatchException();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		app.shutdown();
	}

	public FilmQueryApp() {
		ioManager.init();
	}

	private void shutdown() {
		ioManager.destroy();
	}

}
