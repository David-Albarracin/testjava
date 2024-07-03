package com.campuslands.modules.movieProtagonist.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.core.MySQL;
import com.campuslands.modules.movieProtagonist.domain.models.MovieProtagonist;
import com.campuslands.modules.movieProtagonist.domain.repository.MovieProtagonistRepository;

/**
 * MovieProtagonistMySQL
 */
public class MovieProtagonistMySQL extends MySQL implements MovieProtagonistRepository {



    public MovieProtagonistMySQL(){
        super();
    }

    @Override
    public void save(MovieProtagonist movieProtagonist) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO peliculaprotagonista (idpelicula, idprotagonista, idtipoactor) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, movieProtagonist.getMovieId());
                statement.setInt(2, movieProtagonist.getActorId());
                statement.setInt(3, movieProtagonist.getActorTypeId());

                statement.executeUpdate();
                System.out.println("MovieProtagonist created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MovieProtagonist movieProtagonist) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE peliculaprotagonista SET movieId = ?, actorId = ?, actorTypeId = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, movieProtagonist.getMovieId());
                statement.setInt(2, movieProtagonist.getActorId());
                statement.setInt(3, movieProtagonist.getActorTypeId());

                statement.executeUpdate();
                System.out.println("MovieProtagonist updated successfully!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int movieProtagonistId) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM peliculaprotagonista WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, movieProtagonistId);

                statement.executeUpdate();
                System.out.println("MovieProtagonist deleted successfully!");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<MovieProtagonist> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT movieId, actorId, actorTypeId FROM peliculaprotagonista WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        MovieProtagonist movieProtagonist = new MovieProtagonist(
                                resultSet.getInt("movieId"),
                                resultSet.getInt("actorId"),
                                resultSet.getInt("actorTypeId")
                                );
                        return Optional.of(movieProtagonist);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<MovieProtagonist> findAll() {
        List<MovieProtagonist> movieProtagonists = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT movieId, actorId, actorTypeId FROM peliculaprotagonista";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    MovieProtagonist movieProtagonist = new MovieProtagonist(
                                resultSet.getInt("movieId"),
                                resultSet.getInt("actorId"),
                                resultSet.getInt("actorTypeId")
                                );
                    movieProtagonists.add(movieProtagonist);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieProtagonists;
    }
    
}