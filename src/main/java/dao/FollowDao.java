package dao;

import model.Suggestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FollowDao extends BaseDao {

    public boolean follow(int myId, int followedUserId) {
        boolean followed = false;
        String sql = "insert into " +
                "my_following_tbl " +
                "(my_id, person_i_follow_id) VALUES (?, ?)";
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, myId);
            statement.setInt(2, followedUserId);
            followed = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return followed;
    }

    public List<Suggestion> getSuggestions(int userId) {
        List<Suggestion> list = new ArrayList<>();
        String sql = "select full_name, user_id from user " +
                "where user_id not in " +
                "      (select person_i_follow_id from my_following_tbl WHERE my_id = '"+userId+"') " +
                "  and user_id != '"+userId+"' and user_role_id = 1";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                Suggestion suggestion = new Suggestion(
                        set.getString("full_name"),
                        set.getInt("user_id")
                );
                list.add(suggestion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
