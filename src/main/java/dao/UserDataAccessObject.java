package dao;

import model.User;
import model.UserStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataAccessObject extends BaseDao {

    public boolean saveUser(User userObject) {
        boolean saved = false;
        try {
            String sql = "INSERT INTO user (user_name, gender, email, country, state, city, street, zipcode, status, password)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, userObject.getUserName());
            statement.setString(2, userObject.getGender());
            statement.setString(3, userObject.getEmail());
            statement.setString(4, userObject.getCountry());
            statement.setString(5, userObject.getState());
            statement.setString(6, userObject.getCity());
            statement.setString(7, userObject.getStreet());
            statement.setInt(8, userObject.getZipCode());
            statement.setString(9, userObject.getStatus().name());
            statement.setString(10, User.hashPassword(userObject.getPassword()));

            saved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return saved;
    }

    public User getUser(String email) {
        User user = null;
        try {
            String sql = "SELECT * FROM user where email = '"+ email +"'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
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

    public boolean verifyUser(String email, String password) {
        User user = getUser(email);
        if (user == null) return false;

        String hashedPassword = User.hashPassword(password);
        return user.getPassword().equals(hashedPassword);
    }
}