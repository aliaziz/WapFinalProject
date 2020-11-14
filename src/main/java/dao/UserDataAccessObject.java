package dao;

import model.Profile;
import model.User;
import model.UserStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataAccessObject extends BaseDao {

    public boolean saveUser(User userObject) {
        boolean saved = false;
        try {
            String sql = "INSERT INTO user (user_name, gender, email, full_name, state, city, street, zipcode, status, password, user_role_id)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, userObject.getUserName());
            statement.setString(2, userObject.getGender());
            statement.setString(3, userObject.getEmail());
            statement.setString(4, userObject.getFullname());
            statement.setString(5, userObject.getState());
            statement.setString(6, userObject.getCity());
            statement.setString(7, userObject.getStreet());
            statement.setInt(8, userObject.getZipCode());
            statement.setString(9, userObject.getStatus().name());
            statement.setString(10, User.hashPassword(userObject.getPassword()));
            statement.setInt(11, userObject.getRoleId());

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
                        set.getString("full_name"),
                        set.getString("street"),
                        set.getString("city"),
                        set.getString("gender"),
                        UserStatus.valueOf(set.getString("status")),
                        set.getInt("zipcode"),
                        set.getInt("user_role_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int getUserId(String email) {
        int userId = -1;
        try {
            String sql = "SELECT user_id FROM user where email = '"+ email +"'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
               userId = set.getInt("user_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    public boolean updateProfile(Profile profile) {
        boolean saved = false;
        try {
            String sql = "UPDATE user SET " +
                    "gender='"+profile.getGender()+"'," +
                    "full_name='"+profile.getFullName()+"'," +
                    "state='"+profile.getState()+"', " +
                    "city='"+profile.getCity()+"', " +
                    "street='"+profile.getStreet()+"'," +
                    "zipcode='"+profile.getZipCode()+"' WHERE email='"+profile.getEmail()+"'";

            PreparedStatement statement = getConnection().prepareStatement(sql);
            saved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return saved;
    }

    public int verifyUser(String email, String password) {
        User user = getUser(email);
        if (user == null) return 0;

        String hashedPassword = User.hashPassword(password);
        if (user.getPassword().equals(hashedPassword) && user.getStatus() == UserStatus.ACTIVE) {
            return user.getRoleId();
        } else {
            return -1;
        }
    }

    public int getUserRole(User user) {
        return user.getRoleId();
    }

    public boolean changeUserStatus(int userId, boolean status) {
        String statusString = status ? UserStatus.ACTIVE.name() : UserStatus.INACTIVE.name();
        boolean updated = false;

        try {
            String sql = "UPDATE user SET status " +
                    "= '" + statusString + "' " +
                    "WHERE userId = '" + userId + "'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            updated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }
}
