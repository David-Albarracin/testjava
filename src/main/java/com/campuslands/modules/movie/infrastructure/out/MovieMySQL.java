package com.campuslands.modules.movie.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.core.MySQL;
import com.campuslands.modules.movie.domain.models.Movie;
import com.campuslands.modules.movie.domain.repository.MovieRepository;

/**
 * MovieMySQL
 */
public class MovieMySQL extends MySQL implements MovieRepository {



    public MovieMySQL(){
        super();
    }

    @Override
    public void save(Movie movie) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO pelicula (codinterno, nombre, duracion, sinopsis) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, movie.getCode());
                statement.setString(2, movie.getName());
                statement.setString(3, movie.getDuration());
                statement.setString(4, movie.getSinopsis());

                statement.executeUpdate();
                System.out.println("Movie created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Movie movie) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE movie SET codinterno = ?, nombre = ?, duracion = ?, sinopsis = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, movie.getCode());
                statement.setString(2, movie.getName());
                statement.setString(3, movie.getDuration());
                statement.setString(4, movie.getSinopsis());
                statement.setInt(6, movie.getMovieId());

                statement.executeUpdate();
                System.out.println("Movie updated successfully!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int movieId) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM pelicula WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, movieId);

                statement.executeUpdate();
                System.out.println("Movie deleted successfully!");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Movie> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, codinterno ,nombre, duracion, sinopsis FROM pelicula WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Movie movie = new Movie(
                                resultSet.getInt("id"),
                                resultSet.getString("codinterno"),
                                resultSet.getString("nombre"),
                                resultSet.getString("duracion"),
                                resultSet.getString("sinopsis")
                                );
                        return Optional.of(movie);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, codinterno ,nombre, duracion, sinopsis FROM pelicula";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Movie movie = new Movie(
                                resultSet.getInt("id"),
                                resultSet.getString("codinterno"),
                                resultSet.getString("nombre"),
                                resultSet.getString("duracion"),
                                resultSet.getString("sinopsis")
                                );
                    movies.add(movie);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public void findDetailedInfoById(int movieId) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT " +
                    "p.id, " +
                    "p.codinterno, " +
                    "p.nombre, " +
                    "p.duracion, " +
                    "p.sinopsis, " +
                    "GROUP_CONCAT(DISTINCT CONCAT(f.descripcion, ' (Cantidad: ', pf.cantidad, ')') SEPARATOR ', ') AS formatos, "
                    +
                    "GROUP_CONCAT(DISTINCT CONCAT(a.nombre, ' (Edad: ', a.edad, ', Nacionalidad: ', pa.descripcion, ', Género: ', g.descripcion, ', Tipo: ', ta.descripcion, ')') SEPARATOR '; ') AS actores "
                    +
                    "FROM pelicula p " +
                    "LEFT JOIN peliculaformato pf ON p.id = pf.idpelicula " +
                    "LEFT JOIN formato f ON pf.idformato = f.id " +
                    "LEFT JOIN peliculaprotagonista pp ON p.id = pp.idpelicula " +
                    "LEFT JOIN actor a ON pp.idprotagonista = a.id " +
                    "LEFT JOIN pais pa ON a.idnacionalidad = pa.id " +
                    "LEFT JOIN genero g ON a.idgenero = g.id " +
                    "LEFT JOIN tipoactor ta ON pp.idtipoactor = ta.id " +
                    "WHERE p.id = ? " +
                    "GROUP BY p.id, p.codinterno, p.nombre, p.duracion, p.sinopsis";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, movieId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("");
                        System.out.println("Movie ID: " + resultSet.getInt("id"));
                        System.out.println("Code: " + resultSet.getString("codinterno"));
                        System.out.println("Name: " + resultSet.getString("nombre"));
                        System.out.println("Duration: " + resultSet.getString("duracion"));
                        System.out.println("Sinopsis: " + resultSet.getString("sinopsis"));
                        System.out.println("Formats: " + resultSet.getString("formatos"));
                        System.out.println("Actors: " + resultSet.getString("actores"));
                    } else {
                        System.out.println("No movie found with ID: " + movieId);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}