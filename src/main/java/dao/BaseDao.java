package dao;

import java.sql.Connection;

public class BaseDao {

    public Connection getConnection() {
        return DBConnection.getConnection();
    }
}
