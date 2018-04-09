package com.skilldistillery.filmquery.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.skilldistillery.iomanager.common.*;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static final String username = "student";
	private static final String password = "student";
	private static IOManager ioManager = new SystemIOManager();

	public Film getFilmByKeyword(String keyword) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, username, password);
			String sql = "SELECT f.id, f.title, f.description, f.release_year, l.name, f.rental_duration, f.rental_rate, f.length, f.replacement_cost, f.rating, f.special_features FROM film f JOIN language l ON f.language_id = l.id WHERE (f.title LIKE ?) OR (f.description LIKE ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			String toBeSet = "%" + keyword + "%";
			String secondToBeSet = "%" + keyword + "%";
			stmt.setString(1, toBeSet);
			stmt.setString(2, secondToBeSet);
			ResultSet rs = stmt.executeQuery();
			boolean filmFound = false;
			while (rs.next()) {
				filmFound = true;
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String description = rs.getString(3);
				int releaseYear = rs.getInt(4);
				String language = rs.getString(5);
				int rentalDuration = rs.getInt(6);
				double rentalRate = rs.getDouble(7);
				int length = rs.getInt(8);
				double replacementCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String specialFeatures = rs.getString(11);
				film = new Film(id, title, description, releaseYear, language, rentalDuration, rentalRate, length,
						replacementCost, rating, specialFeatures);
				List<Actor> cast = getActorsByFilmId(id);
				film.setCast(cast);
//				ioManager.print(new Text("\n" + film.toString()));
				film.printFilm(film);
			}
			if (!filmFound) {
				ioManager.print(new TextWithNewLine("No matching films."));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			ioManager.print(new TextWithNewLine("An error occurred, please make another selection."));
//			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Film getFilmById(int filmId) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, username, password);
			String sql = "SELECT f.id, f.title, f.description, f.release_year, l.name, f.rental_duration, f.rental_rate, f.length, f.replacement_cost, f.rating, f.special_features FROM film f JOIN language l ON f.language_id = l.id WHERE f.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			boolean filmFound = false;
			if (rs.next()) {
				filmFound = true;
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String description = rs.getString(3);
				int releaseYear = rs.getInt(4);
				String language = rs.getString(5);
				int rentalDuration = rs.getInt(6);
				double rentalRate = rs.getDouble(7);
				int length = rs.getInt(8);
				double replacementCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String specialFeatures = rs.getString(11);
				film = new Film(id, title, description, releaseYear, language, rentalDuration, rentalRate, length,
						replacementCost, rating, specialFeatures);
				List<Actor> cast = getActorsByFilmId(filmId);
				film.setCast(cast);
				film.printFilm(film);
			}
			if (!filmFound) {
				ioManager.print(new TextWithNewLine("No matching films."));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			ioManager.print(new TextWithNewLine("An error occurred, please make another selection."));
//			e.printStackTrace();
		}

		return film;
	}

	@Override
	public Actor getActorById(int actorId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, username, password);
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				actor = new Actor(id, firstName, lastName);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			ioManager.print(new TextWithNewLine("An error occurred, please make another selection."));
//			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) {
		Film film = null;
		List<Actor> cast = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, username, password);
			String sql = "SELECT a.first_name, a.last_name, a.id FROM actor a JOIN film_actor fa ON a.id = fa.actor_id WHERE fa.film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				int id = rs.getInt(3);
				Actor actor = new Actor(id, firstName, lastName);
				cast.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			ioManager.print(new TextWithNewLine("An error occurred, please make another selection."));
//			e.printStackTrace();
		}
		return cast;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load DB driver. Exiting.");
			e.printStackTrace();
			System.exit(1);
		}
	}

}
