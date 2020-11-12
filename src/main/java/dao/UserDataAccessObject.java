package dao;

import model.User;
import model.UserStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataAccessObject {
    private User user;

    public UserDataAccessObject(User user) {
        this.user = user;
    }

    public boolean saveUser() {
        Connection connection = DBConnection.getConnection();
        boolean saved = false;
        try {
            String sql = "INSERT INTO user (user_name, gender, email, country, state, city, street, zipcode, status, password)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getGender());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getCountry());
            statement.setString(5, user.getState());
            statement.setString(6, user.getCity());
            statement.setString(7, user.getStreet());
            statement.setInt(8, user.getZipCode());
            statement.setString(9, user.getStatus().name());
            statement.setString(10, User.hashPassword(user.getPassword()));

            saved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return saved;
    }

    public User getUser(String userName) {
        Connection connection = DBConnection.getConnection();
        User user = null;
        try {
            String sql = "SELECT * FROM user where user_name = '"+userName+"'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                user = new User(
                        set.getString("email"),
                        set.getString("user_name"),
                        set.getString("password"),
                        set.getString("state"),
                        set.getString("country"),
                        set.getString("street"),
                        set.getString("city"),
                        set.getString("gender"),
                        UserStatus.valueOf(set.getString("status")),
                        set.getInt("zipcode")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
