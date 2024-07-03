package com.campuslands.modules.genre.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.core.MySQL;
import com.campuslands.modules.genre.domain.models.Genre;
import com.campuslands.modules.genre.domain.repository.GenreRepository;


public class GenreMySQL extends MySQL implements GenreRepository {

    public GenreMySQL(){
        super();
    }


    @Override
    public void save(Genre genre) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO genre (name) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, genre.getName());

                statement.executeUpdate();
                System.out.println("Genre created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Genre genre) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE genre SET name = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, genre.getName());

                statement.executeUpdate();
                System.out.println("Genre updated successfully!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int genreId) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM genre WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, genreId);

                statement.executeUpdate();
                System.out.println("Genre deleted successfully!");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Genre> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name FROM genre WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Genre genre = new Genre(
                                resultSet.getInt("id"),
                                resultSet.getString("name")
                                );
                        return Optional.of(genre);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Genre> findAll() {
        List<Genre> genres = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name FROM genre";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Genre genre = new Genre(
                                resultSet.getInt("id"),
                                resultSet.getString("name")
                                );
                    genres.add(genre);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }
    
}