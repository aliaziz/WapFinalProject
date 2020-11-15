package dao;

import java.sql.*;

public class DBConnection {
    private static Connection connection;
    private DBConnection() { }

    public static Connection getConnection() {
        if (connection == null) {
            try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               connection =
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/itravel_db", "root", "user123");

            } catch ( ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
