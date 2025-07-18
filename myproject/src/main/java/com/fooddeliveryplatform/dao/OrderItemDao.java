package com.fooddeliveryplatform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fooddeliveryplatform.model.OrderItem;
import com.fooddeliveryplatform.util.DatabaseConnection;

public class OrderItemDao implements Dao<OrderItem> {
    
    @Override
    public OrderItem get(int id) {
        String sql = "SELECT * FROM order_items WHERE order_item_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new OrderItem(
                        rs.getLong("order_item_id"),
                        rs.getDouble("price_per_unit"),
                        rs.getInt("quantity"),
                        rs.getString("special_instructions"),
                        rs.getLong("food_item_id"),
                        rs.getLong("order_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Placeholder
    }

    @Override
    public List<OrderItem> getAll() throws SQLException {
        String sql = "SELECT * FROM order_items";
        List<OrderItem> orderItems = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                orderItems.add(new OrderItem(
                        rs.getLong("order_item_id"),
                        rs.getDouble("price_per_unit"),
                        rs.getInt("quantity"),
                        rs.getString("special_instructions"),
                        rs.getLong("food_item_id"),
                        rs.getLong("order_id")
                ));
            }
            return orderItems;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(); // Return empty list if no items found
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        String sql = "INSERT INTO order_items (price_per_unit, quantity, special_instructions, food_item_id, order_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setDouble(1, orderItem.getPricePerUnit());
            pstmt.setInt(2, orderItem.getQuantity());
            pstmt.setString(3, orderItem.getSpecialInstructions());
            pstmt.setLong(4, orderItem.getFoodItemId());
            pstmt.setLong(5, orderItem.getOrderId());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        orderItem.setFoodItemId(generatedKeys.getLong(1));
                        return orderItem;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Placeholder
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        // Implementation to update an OrderItem
        return null; // Placeholder
    }

    @Override
    public void delete(OrderItem orderItem) {
        // Implementation to delete an OrderItem
    }
    
}
