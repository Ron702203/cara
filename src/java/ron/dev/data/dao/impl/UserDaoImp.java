package ron.dev.data.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ron.dev.data.dao.UserDao;
import ron.dev.data.dao.model.User;
import ron.dev.data.driver.MySQLDriver;
import ron.dev.until.MD5Hashing;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoImp implements UserDao {

    private Connection conn;

    public UserDaoImp() {
        this.conn = MySQLDriver.getInstance().getConnection();

    }

    @Override
    public boolean insert(User user) {
        // TODO Auto-generated method stub
        try {
            String sql = "INSERT INTO USERS(ID,NAME, EMAIL, PASSWORD,ROLE) VALUES(NULL,?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getName());

            stmt.setString(2, user.getEmail());
            stmt.setString(3, MD5Hashing.getMD5(user.getPassword()));
            stmt.setString(4, user.getRole());
            stmt.execute();

            return stmt.execute();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean update(User user) {
        // TODO Auto-generated method stub
        try {
            String sql = "UPDATE USERS SET EMAIL=?, PASSWORD=?, ROLE=?, WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        try {

            String sql = "DELETE FROM USERS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public User find(int id) {
        try {
            String sql = "SELECT * FROM USERS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");

                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");

                return new User(id, name, email, password, role);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM USERS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                userList.add(new User(id, name, email, password, role));
            }
        } catch (SQLException ex) {
        }

        return userList;
    }

    @Override
    public User find(String email, String password) {
        try {
            String sql = "SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(2, email);
            stmt.setString(3, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String role = rs.getString("role");
                String name = rs.getString("name");

                return new User(id, name, email, password, role
                );
            }
        } catch (SQLException ex) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM USERS WHERE EMAIL=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String role = rs.getString("role");

                return new User(id, name, email, password, role);
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    @Override
    public int countUser() {

        String sql = "SELECT COUNT(*) AS count FROM users";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countUser = rs.getInt("count");
                return countUser;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
