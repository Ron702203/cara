/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ron.dev.data.dao.impl;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ron.dev.data.dao.OrderDao;
import ron.dev.data.dao.model.Order;
import ron.dev.data.driver.MySQLDriver;

/**
 *
 * @author ACER
 */
public class OrderDaoImp implements OrderDao {

    private final Connection conn;

    public OrderDaoImp() {
        this.conn = (Connection) MySQLDriver.getInstance().getConnection();
    }

    @Override
    public void insert(Order order) {
        try {
            String sql = "INSERT INTO ORDERS(ID, CODE, DESCRIPTION, STATUS, USER_ID) VALUES(NULL,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, order.code);
            stmt.setString(2, order.description);
            stmt.setString(3, order.status);
            stmt.setInt(4, order.userId);

            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            Logger.getLogger("insert order").log(Level.SEVERE, e.toString());
        }
    }

    @Override
    public void update(Order order) {
        try {
            String sql = "UPDATE ORDERS SET CODE=?, DESCRIPTION=?, STATUS=?, USER_ID =? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, order.code);
            stmt.setString(2, order.description);
            stmt.setString(3, order.status);
            stmt.setInt(4, order.userId);

            stmt.setInt(5, order.id);
            stmt.execute();
        } catch (SQLException e) {
        }
    }

    @Override
    public void delete(int orderId) {
        try {
            String sql = "DELETE FROM ORDERS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, orderId);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public Order find(int orderId) {
        try {
            String sql = "SELECT * FROM ORDERS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderId);
            ResultSet rs = (ResultSet) stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String description = rs.getString("description");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                return new Order(id, code, description, status, userId);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public Order find(String code) {
        try {
            String sql = "SELECT * FROM ORDERS WHERE CODE = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("description");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                return new Order(id, code, description, status, userId);
            }

        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDERS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String description = rs.getString("description");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                orderList.add(new Order(id, code, description, status, userId));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return orderList;
    }

    @Override
    public List<Order> findByStatus(String status) {
        List<Order> orderList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDERS WHERE STATUS=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String description = rs.getString("description");
                int userId = rs.getInt("user_id");
                orderList.add(new Order(id, code, description, status, userId));
            }
        } catch (SQLException ex) {
        }

        return orderList;
    }

    @Override
    public int countOrderByDay(String date) {
        int count = 0;
        String sql = "SELECT COUNT(*) AS count FROM orders where date(created_at)=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public int countOrder() {
        String sql = "SELECT COUNT(*) AS count FROM orders";
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countOrder = rs.getInt("count");
                return countOrder;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int countPendingOrder() {
        String sql = "SELECT COUNT(*) AS count FROM orders WHERE STATUS = 'pending'";
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countPendingOrder = rs.getInt("count");
                return countPendingOrder;

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int countShippingOrder() {
        String sql = "SELECT COUNT(*) AS count FROM orders WHERE STATUS = 'SHIPPING'";
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countShippingOrder = rs.getInt("count");
                return countShippingOrder;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int countDeliveredOrder() {
        String sql = "SELECT COUNT(*) AS count FROM orders WHERE STATUS = 'DELIVERED'";
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countDeliveredOrder = rs.getInt("count");
                return countDeliveredOrder;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int countCanceledOrder() {
        String sql = "SELECT COUNT(*) AS count FROM orders WHERE STATUS = 'CANCELED'";
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countDeliveredOrder = rs.getInt("count");
                return countDeliveredOrder;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
