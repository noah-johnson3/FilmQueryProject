package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	public Film findFilmById(int filmId) {
		String user = "student";
		String pass = "student";
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
//			String sql = "SELECT * FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";
			String sql = "SELECT film.title, film.description, film.id, film.release_year, film.language_id, film.rating FROM film JOIN language ON film.language_id = language.id WHERE film.id =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				film = new Film();
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setRating(rs.getString("rating"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setLanguage(languageAsString(rs.getInt(3)));

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		String user = "student";
		String pass = "student";
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor(); // Create the object
				actor.setId(actorResult.getInt(1));
				actor.setFirstName(actorResult.getString(2));
				actor.setLastName(actorResult.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		String user = "student";
		String pass = "student";
		List<Actor> actorsList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor"
					+ " JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_actor.film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet actorsResult = stmt.executeQuery();
			while (actorsResult.next()) {

				String firstName = actorsResult.getString("first_name");
				String lastName = actorsResult.getString("last_name");
				int actorId = actorsResult.getInt("id");

				Actor actor = new Actor(firstName, lastName, actorId);

				actorsList.add(actor);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actorsList;
	}

	public List<Film> keyWordFilmList(String searchWord) {

		String user = "student";
		String pass = "student";
		List<Film> filmList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT film.title, film.description, film.id, film.release_year, film.language_id, film.rating FROM film WHERE title LIKE ? OR description LIKE ?";
			PreparedStatement prepStatment = conn.prepareStatement(sql);
			prepStatment.setString(1, "%" + searchWord + "%");
			prepStatment.setString(2, "%" + searchWord + "%");
			ResultSet rs = prepStatment.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setRating(rs.getString("rating"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setLanguage(languageAsString(rs.getInt(3)));
				filmList.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmList;
	}

	public String languageAsString(int filmId) {
		String user = "student";
		String pass = "student";
		String languageName = "";
		
		try {
			
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT name FROM language JOIN film ON language.id = film.language_id WHERE film.id = ?";
			PreparedStatement prepStatment = conn.prepareStatement(sql);
			prepStatment.setInt(1, filmId);
			ResultSet rs = prepStatment.executeQuery();
			rs.next();
			languageName = rs.getString("name");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return languageName;
	}

}