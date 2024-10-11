package ron.dev.data.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDriver {
	final String DB_URL = "jdbc:mysql://localhost:3306/shop";
    final String USER = "root";
    final String PASS = "123456";
    private static MySQLDriver instance;

    private MySQLDriver() {
    }

    public static MySQLDriver getInstance() {
        if (instance == null) {
            instance = new MySQLDriver();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block

        }
        return null;
    }

//    public ProductDao getProductDao() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public CategoryDao getCategoryDao() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

}
