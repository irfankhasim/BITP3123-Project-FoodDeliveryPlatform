package com.fooddeliveryplatform.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fooddeliveryplatform.model.Order;
import com.fooddeliveryplatform.model.OrderStatus;
import com.fooddeliveryplatform.util.DatabaseConnection;

public class OrderDao implements Dao<Order> {
    // Implementation of methods to interact with the Order database table
    @Override
    public Order get(int id) {
        String sql = "SELECT * FROM orders WHERE order_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Order(
                        rs.getLong("order_id"),
                        rs.getDate("created_at"),
                        rs.getString("delivery_address"),
                        OrderStatus.valueOf(rs.getString("status")),
                        rs.getDouble("total_amount"),
                        rs.getLong("customer_id"),
                        rs.getLong("restaurant_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Placeholder
    }

    @Override
    public List<Order> getAll() throws SQLException {
        String sql = "SELECT * FROM orders";
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                orders.add(new Order(
                        rs.getLong("order_id"),
                        rs.getDate("created_at"),
                        rs.getString("delivery_address"),
                        OrderStatus.valueOf(rs.getString("status")),
                        rs.getDouble("total_amount"),
                        rs.getLong("customer_id"),
                        rs.getLong("restaurant_id")
                ));
            }
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Placeholder
    }

    @Override
    public Order save(Order order) {
        String sql = "INSERT INTO orders (created_at, delivery_address, status, total_amount, customer_id, restaurant_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, new Date(order.getCreatedAt().getTime()));
            pstmt.setString(2, order.getDeliveryAddress());
            pstmt.setString(3, order.getStatus().name());
            pstmt.setDouble(4, order.getTotalAmount());
            pstmt.setLong(5, order.getCustomerId());
            pstmt.setLong(6, order.getRestaurantId());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        order.setOrderId(generatedKeys.getLong(1));
                        return order;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Placeholder
    }

    @Override
    public Order update(Order order) {
        // Logic to update an existing order
        return null; // Placeholder
    }

    @Override
    public void delete(Order order) {
        // Logic to delete an order
    }
    
}
