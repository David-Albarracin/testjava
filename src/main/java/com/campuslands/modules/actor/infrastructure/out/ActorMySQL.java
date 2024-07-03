package com.campuslands.modules.actor.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.core.MySQL;
import com.campuslands.modules.actor.domain.models.Actor;
import com.campuslands.modules.actor.domain.repository.ActorRepository;


public class ActorMySQL extends MySQL implements ActorRepository {

    public ActorMySQL(){
        super();
    }


    @Override
    public void save(Actor actor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO actor (nombre, edad, idnacionalidad, idgenero) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, actor.getName());
                statement.setInt(2, actor.getAge());
                statement.setInt(3, actor.getCountryId());
                statement.setInt(4, actor.getGenreId());

                statement.executeUpdate();
                System.out.println("Actor created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Actor actor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE actor SET nombre = ?, edad = ?, idnacionalidad = ?, idgenero = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, actor.getName());
                statement.setInt(2, actor.getAge());
                statement.setInt(3, actor.getCountryId());
                statement.setInt(4, actor.getGenreId());
                statement.setInt(5, actor.getActorId());

                statement.executeUpdate();
                System.out.println("Actor updated successfully!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int actorId) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM actor WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, actorId);

                statement.executeUpdate();
                System.out.println("Actor deleted successfully!");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Actor> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, nombre, edad, idnacionalidad, idgenero FROM actor WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Actor actor = new Actor(
                                resultSet.getInt("id"),
                                resultSet.getString("nombre"),
                                resultSet.getInt("edad"),
                                resultSet.getInt("idnacionalidad"),
                                resultSet.getInt("idgenero")
                                );
                        return Optional.of(actor);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Actor> findAll() {
        List<Actor> actors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, nombre, edad, idnacionalidad, idgenero FROM actor";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Actor actor = new Actor(
                                resultSet.getInt("id"),
                                resultSet.getString("nombre"),
                                resultSet.getInt("edad"),
                                resultSet.getInt("idnacionalidad"),
                                resultSet.getInt("idgenero")
                                );
                    actors.add(actor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    
}