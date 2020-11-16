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

    public List<Post> getUnhealthyPost() {
        List<Post> postList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM post_tbl WHERE post_health = '0'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Post post = new Post(
                        set.getString("post_image_url"),
                        set.getString("post_desc"),
                        set.getInt("likes_count"),
                        set.getInt("post_user_id"),
                        set.getDouble("post_lat"),
                        set.getDouble("post_lon")
                );
                post.setPostId(set.getInt("post_id"));
                post.setPosterFullName(set.getString("full_name"));
                post.setPostHealth(set.getInt("post_health"));
                postList.add(post);
            }

        } catch (SQLException e) {e.printStackTrace();}
        return postList;
    }

    public List<Post> getPosts(int userId) {
        List<Post> postList = new ArrayList<>();

        try {
            String sql = "SELECT u.full_name," +
                    " p.post_id," +
                    " p.post_image_url," +
                    " p.post_desc," +
                    " p.post_lat," +
                    " p.post_lon," +
                    " p.likes_count FROM post_tbl p, user u" +
                    " where p.post_user_id = u.user_id" +
                    " and p.post_health = 1" +
                    " and post_user_id in " +
                    "(select person_i_follow_id from my_following_tbl where my_id = '" + userId + "')" +
                    " ORDER BY post_date";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Post post = new Post(
                        set.getString("post_image_url"),
                        set.getString("post_desc"),
                        set.getInt("likes_count"),
                        userId,
                        set.getDouble("post_lat"),
                        set.getDouble("post_lon"));
                post.setPostId(set.getInt("post_id"));
                post.setPosterFullName(set.getString("full_name"));
                postList.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public boolean savePost(Post post) {
        boolean isSaved = false;
        String sql = "INSERT into post_tbl " +
                "(post_image_url, post_desc, " +
                "likes_count, post_date, " +
                "post_user_id, post_lat, post_lon, post_health) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, post.getPostImageUrl());
            statement.setString(2, post.getDescription());
            statement.setInt(3, post.getLikes());
            statement.setDate(4, Date.valueOf(LocalDate.now()));
            statement.setInt(5, post.getUserId());
            statement.setDouble(6, post.getPostLat());
            statement.setDouble(7, post.getPostLong());
            statement.setInt(8, post.getPostHealth());

            isSaved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSaved;
    }

    public List<Post> searchPost(String query) {
        List<Post> postList = new ArrayList<>();
        try {
            String sql = "SELECT u.full_name," +
                    " p.post_id," +
                    " p.post_image_url," +
                    " p.post_desc, " +
                    " p.post_user_id," +
                    " p.post_lat," +
                    " p.post_lon," +
                    " p.likes_count FROM post_tbl p, user u" +
                    " where p.post_user_id = u.user_id " +
                    " and p.post_health = 1" +
                    " and post_desc LIKE '%"+query+"%'" +
                    " ORDER BY post_date";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Post post = new Post(
                        set.getString("post_image_url"),
                        set.getString("post_desc"),
                        set.getInt("likes_count"),
                        set.getInt("post_user_id"),
                        set.getDouble("post_lat"),
                        set.getDouble("post_lon")
                );
                post.setPostId(set.getInt("post_id"));
                post.setPosterFullName(set.getString("full_name"));
                postList.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public boolean deletePost(int postId) {
        boolean deleted = false;
        try {
            String sql = "DELETE from post_tbl WHERE post_id='"+postId+"'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            deleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }

    public int likeOrUnlikePost(boolean shouldLike, int postId, int userId) {
        int countIncrementer = shouldLike ? 1 : -1;
        int likesCount = 0;
        try {
            String sql = "UPDATE post_tbl SET likes_count = likes_count + '"+countIncrementer+"' " +
                    "WHERE post_id = '"+postId+"'";
            PreparedStatement statement = getConnection().prepareStatement(sql);

            if(statement.executeUpdate() > 0) {
                String likedSql = "SELECT likes_count FROM post_tbl WHERE post_id='"+postId+"'";
                statement = getConnection().prepareStatement(likedSql);
                ResultSet set = statement.executeQuery();
                while (set.next()) {
                    likesCount = set.getInt("likes_count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likesCount;
    }
}
