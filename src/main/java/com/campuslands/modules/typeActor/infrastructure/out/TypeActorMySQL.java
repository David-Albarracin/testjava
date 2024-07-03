package com.campuslands.modules.typeActor.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.core.MySQL;
import com.campuslands.modules.typeActor.domain.models.TypeActor;
import com.campuslands.modules.typeActor.domain.repository.TypeActorRepository;

/**
 * TypeActorMySQL
 */
public class TypeActorMySQL extends MySQL implements TypeActorRepository {



    public TypeActorMySQL(){
        super();
    }

    @Override
    public void save(TypeActor actorType) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO tipoactor (descripcion) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, actorType.getDescription());

                statement.executeUpdate();
                System.out.println("Actor Type created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TypeActor actorType) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE tipoactor SET descripcion = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, actorType.getDescription());
                
                statement.executeUpdate();
                System.out.println("Actor Type updated successfully!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int actorTypeId) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM tipoactor WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, actorTypeId);

                statement.executeUpdate();
                System.out.println("Actor Type deleted successfully!");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<TypeActor> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, descripcion FROM tipoactor WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        TypeActor actorType = new TypeActor(
                                resultSet.getInt("id"),
                                resultSet.getString("descripcion")
                                );
                        return Optional.of(actorType);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<TypeActor> findAll() {
        List<TypeActor> actorTypes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, descripcion FROM tipoactor";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    TypeActor actorType = new TypeActor(
                                resultSet.getInt("id"),
                                resultSet.getString("descripcion")
                                );
                    actorTypes.add(actorType);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actorTypes;
    }
    
}