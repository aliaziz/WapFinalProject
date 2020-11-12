package dao;

import controller.DBConnection;

import java.sql.Connection;

public class BaseDao {
    private Connection connection;

    public Connection getConnection() {
        return DBConnection.getConnection();
    }
}
