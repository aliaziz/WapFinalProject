package controller;

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

    public static void test() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM user");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                String s = set.getString("user_id");
                System.out.println(s);
            }
            System.out.println("Failed to get data, "+set.getFetchSize());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
