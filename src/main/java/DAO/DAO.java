package DAO;

import java.sql.*;

public class DAO {
    private static  Connection conn = null;
    public static Connection DBConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/canteenManagementSystem";
        String userName = "root";
        String password = "kaku0001";
        Connection conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }
}

