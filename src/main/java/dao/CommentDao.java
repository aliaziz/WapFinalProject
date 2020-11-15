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
            String sql =
                    "SELECT u.full_name, c.comment_post_id," +
                            "c.comment_user_id, " +
                            "c.comment," +
                            "c.comment_id " +
                            "FROM comment_tbl c, user u" +
                            " WHERE c.comment_user_id = u.user_id" +
                            " and comment_post_id='" + postId + "'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                Comment comment = new Comment(
                        set.getInt("comment_post_id"),
                        set.getInt("comment_user_id"),
                        set.getString("comment")
                );
                comment.setCommentId(set.getInt("comment_id"));
                comment.setFullName(set.getString("full_name"));
                commentList.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentList;
    }

    public boolean saveComment(Comment comment) {
        boolean saved = false;
        try {
            String sql = "INSERT INTO comment_tbl (comment, comment_post_id, comment_user_id) " +
                    "VALUES(?, ?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(2, comment.getPostId());
            statement.setString(1, comment.getComment());
            statement.setInt(3, comment.getUserId());

            saved = statement.executeUpdate() > 0;
        } catch (SQLException e) {e.printStackTrace();}
        return saved;
    }

    public boolean deleteComment(int commentId, int postId) {
        boolean deleted = false;

        try {
            String sql = "DELETE from comment_tbl WHERE commentId='"+commentId+"'" +
                    "AND comment_post_id='"+postId+"'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            deleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deleted;
    }
}
