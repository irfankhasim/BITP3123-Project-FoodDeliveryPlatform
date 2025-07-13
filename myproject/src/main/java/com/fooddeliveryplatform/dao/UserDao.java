package com.fooddeliveryplatform.dao;

import com.fooddeliveryplatform.model.User;
import com.fooddeliveryplatform.model.UserRole;
import com.fooddeliveryplatform.util.DatabaseConnection;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDao implements Dao<User> {
    // Implement methods from Dao interface
    @Override
    public User get(int id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getLong("user_id"),
                        rs.getString("username"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("full_name"),
                        rs.getBoolean("is_active"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        UserRole.valueOf(rs.getString("role"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // null if user not found
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getLong("user_id"),
                        rs.getString("username"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("full_name"),
                        rs.getBoolean("is_active"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        UserRole.valueOf(rs.getString("role"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // null if user not found
    }

    public User findById (Long userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getLong("user_id"),
                        rs.getString("username"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("full_name"),
                        rs.getBoolean("is_active"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        UserRole.valueOf(rs.getString("role"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // null if user not found
    }

    @Override
    public List<User> getAll() throws SQLException {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                users.add(new User(
                        rs.getLong("user_id"),
                        rs.getString("username"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("full_name"),
                        rs.getBoolean("is_active"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        UserRole.valueOf(rs.getString("role")))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for (User user : users) {
            jsonArrayBuilder.add(user.toJson());
        }
        JsonObject jsonResponse = Json.createObjectBuilder()
                .add("users", jsonArrayBuilder)
                .build();
        System.out.println(jsonResponse.toString());
        return users;
    }

    @Override
    public User save(User user) {
        String sql = "INSERT INTO users (username, email, password, role, full_name, phone, address,is_active) VALUES (?, ?, ?, ?, ?, ?, ?,1)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getRole().name());
            pstmt.setString(5, user.getFullName());
            pstmt.setString(6, user.getPhone());
            pstmt.setString(7, user.getAddress());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setUserId(generatedKeys.getLong(1));
                        return user;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User update(User user) {
        // Logic to update a user
        return null;
    }

    @Override
    public void delete(User user) {
        // Logic to delete a user
    }

}
