package com.campuslands.modules.movieFormat.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.core.MySQL;
import com.campuslands.modules.movieFormat.domain.models.MovieFormat;
import com.campuslands.modules.movieFormat.domain.repository.MovieFormatRepository;

/**
 * MovieFormatMySQL
 */
public class MovieFormatMySQL extends MySQL implements MovieFormatRepository {



    public MovieFormatMySQL(){
        super();
    }

    @Override
    public void save(MovieFormat movieFormat) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO movie_format (formatId, movieId, amount) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, movieFormat.getFormatId());
                statement.setInt(2, movieFormat.getMovieId());
                statement.setInt(3, movieFormat.getAmount());

                statement.executeUpdate();
                System.out.println("MovieFormat created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MovieFormat movieFormat) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE movie_format SET formatId = ?, movieId = ?, amount = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, movieFormat.getFormatId());
                statement.setInt(2, movieFormat.getMovieId());
                statement.setInt(3, movieFormat.getAmount());
                statement.setString(4, movieFormat.getId());

                statement.executeUpdate();
                System.out.println("MovieFormat updated successfully!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int movieFormatId) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM movie_format WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, movieFormatId);

                statement.executeUpdate();
                System.out.println("MovieFormat deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<MovieFormat> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT formatId, movieId, amount FROM movie_format WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        MovieFormat movieFormat = new MovieFormat(
                                resultSet.getInt("formatId"),
                                resultSet.getInt("movieId"),
                                resultSet.getInt("amount")
                                );
                        return Optional.of(movieFormat);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<MovieFormat> findAll() {
        List<MovieFormat> movieFormats = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT formatId, movieId, amount FROM movie_format";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    MovieFormat movieFormat = new MovieFormat(
                                resultSet.getInt("formatId"),
                                resultSet.getInt("movieId"),
                                resultSet.getInt("amount")
                                );
                    movieFormats.add(movieFormat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieFormats;
    }
    
}