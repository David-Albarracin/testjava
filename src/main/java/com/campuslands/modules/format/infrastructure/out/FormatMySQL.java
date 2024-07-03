package com.campuslands.modules.format.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.core.MySQL;
import com.campuslands.modules.format.domain.models.Format;
import com.campuslands.modules.format.domain.repository.FormatRepository;


public class FormatMySQL extends MySQL implements FormatRepository {

    public FormatMySQL(){
        super();
    }


    @Override
    public void save(Format format) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO format (name) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, format.getName());

                statement.executeUpdate();
                System.out.println("Format created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Format format) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE format SET name = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, format.getName());

                statement.executeUpdate();
                System.out.println("Format updated successfully!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int formatId) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM format WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, formatId);

                statement.executeUpdate();
                System.out.println("Format deleted successfully!");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Format> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name FROM format WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Format format = new Format(
                                resultSet.getInt("id"),
                                resultSet.getString("name")
                                );
                        return Optional.of(format);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Format> findAll() {
        List<Format> formats = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name FROM format";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Format format = new Format(
                                resultSet.getInt("id"),
                                resultSet.getString("name")
                                );
                    formats.add(format);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return formats;
    }
    
}