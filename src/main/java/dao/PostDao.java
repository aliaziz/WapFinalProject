package dao;

import model.Post;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostDao extends BaseDao {

    public List<Post> getPosts(int userId) {
        List<Post> postList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM post_tbl " +
                    "where post_user_id in " +
                    "(select person_i_follow_id from my_following_tbl where my_id = '" + userId + "')";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Post post = new Post(
                        set.getString("post_image_url"),
                        set.getString("post_desc"),
                        set.getInt("likes_count"),
                        userId
                );
                post.setPostId(set.getInt("post_id"));
                postList.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public boolean savePost(Post post) {
        boolean isSaved = false;
        String sql = "INSERT into post_tbl (post_image_url, post_desc, likes_count, post_date, post_user_id) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, post.getPostImageUrl());
            statement.setString(2, post.getDescription());
            statement.setInt(3, post.getLikes());
            statement.setDate(4, Date.valueOf(LocalDate.now()));
            statement.setInt(5, post.getUserId());

            isSaved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSaved;
    }
}
