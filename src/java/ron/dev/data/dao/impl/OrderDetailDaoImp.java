/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ron.dev.data.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ron.dev.data.dao.OrderDetailDao;
import ron.dev.data.dao.model.OrderDetail;
import ron.dev.data.driver.MySQLDriver;

/**
 *
 * @author ACER
 */
public class OrderDetailDaoImp implements OrderDetailDao {

    private final Connection conn;

    public OrderDetailDaoImp() {
        this.conn = (Connection) MySQLDriver.getInstance().getConnection();
    }

    @Override
    public void insert(OrderDetail orderdetail) {
        try {
            String sql = "INSERT INTO ORDER_DETAILS(id, amount, product_id, order_id, price) VALUES(NULL,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderdetail.amount);
            stmt.setInt(2, orderdetail.product_id);
            stmt.setInt(3, orderdetail.order_id);
            stmt.setDouble(4, orderdetail.price);

            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void update(OrderDetail orderdetail) {
        try {
            String sql = "UPDATE ORDER_DETAILS SET AMOUNT=?, PRODUCT_ID=?, ORDER_ID =?, PRICE=? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderdetail.amount);
            stmt.setInt(2, orderdetail.product_id);
            stmt.setInt(3, orderdetail.order_id);
            stmt.setDouble(4, orderdetail.price);
            stmt.setInt(5, orderdetail.id);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void delete(int orderdetailId) {
        try {
            String sql = "DELETE FROM ORDER_DETAILS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, orderdetailId);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public OrderDetail find(int orderdetailId) {
        try {
            String sql = "SELECT * FROM ORDER_DETAILS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderdetailId);
            ResultSet rs = (ResultSet) stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                int amount = rs.getInt("amount");
                int product_id = rs.getInt("product_id");
                int order_id = rs.getInt("order_id");
                double price = rs.getDouble("price");
                return new OrderDetail(id, amount, product_id, order_id, price);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<OrderDetail> findALL() {
        List<OrderDetail> orderdetailList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDER_DETAILS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int amount = rs.getInt("amount");
                int product_id = rs.getInt("product_id");
                int order_id = rs.getInt("order_id");
                double price = rs.getDouble("price");
                orderdetailList.add(new OrderDetail(id, amount, product_id, order_id, price));
            }
        } catch (SQLException ex) {
        }

        return orderdetailList;
    }

    @Override
    public List<OrderDetail> findByOrder(int orderId) {
        List<OrderDetail> orderdetail = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDER_DETAILS WHERE ORDER_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int amount = rs.getInt("amount");
                int productId = rs.getInt("product_id");
                double price = rs.getDouble("price");
                orderdetail.add(new OrderDetail(amount, productId, orderId, price));
            }
        } catch (SQLException ex) {
        }

        return orderdetail;
    }
}

