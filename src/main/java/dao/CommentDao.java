package dao;

import model.Comment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDao extends BaseDao {

    public List<Comment> getComments(int postId) {
        List<Comment> commentList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM comment_tbl WHERE comment_post_id='" + postId + "'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                Comment comment = new Comment(
                        set.getInt("comment_post_id"),
                        set.getInt("comment_user_id"),
                        set.getString("comment")
                );
                comment.setCommentId(set.getInt("comment_id"));
                commentList.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentList;
    }
}
