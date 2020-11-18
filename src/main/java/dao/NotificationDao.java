package dao;

import model.Notification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationDao extends BaseDao {

    public boolean saveNotification(int postId, int userId) {
        boolean saved = false;
        String sql = "insert into" +
                " notification_tbl (notification_post_id, notification_user_id)" +
                " values (?,?) ";
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, postId);
            statement.setInt(2, userId);
            saved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saved;
    }

    public List<Notification> getNotification(int userId) {
        List<Notification> list = new ArrayList<>();
        String sql = "select n.notification_post_id, n.notification_id, n.notification_user_id, p.post_desc, u.full_name from notification_tbl n, post_tbl p, user u " +
                "WHERE n.notification_post_id = p.post_id" +
                "  and p.post_user_id = u.user_id " +
                "and n.notification_user_id in (select person_i_follow_id from my_following_tbl where my_id = '" + userId + "')";
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Notification notification = new Notification(
                        set.getInt("notification_id"),
                        set.getInt("notification_user_id"),
                        set.getInt("notification_post_id")
                );
                notification.setPosterFullName(set.getString("full_name"));
                notification.setPostSummary(set.getString("post_desc"));
                list.add(notification);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
