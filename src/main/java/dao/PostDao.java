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

            String sql = "SELECT u.full_name," +
                    " p.post_id," +
                    " p.post_image_url," +
                    " p.post_desc, " +
                    " p.post_user_id," +
                    " p.post_lat," +
                    " p.post_lon," +
                    " p.likes_count FROM post_tbl p, user u" +
                    " where p.post_user_id = u.user_id " +
                    " and p.post_health = 0";

            getPreparedStatement(postList, sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public boolean liveUnhealthyPost(int postId) {
        boolean lived = false;
        try {
            String sql = "UPDATE post_tbl SET post_health = '1' WHERE post_id = '"+postId+"'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            lived = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lived;
    }

    public boolean deleteUnhealthyPost(int postId) {
        boolean deleted = false;
        try {
            String sql = "DELETE from post_tbl WHERE post_id = '"+postId+"'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            deleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
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
                    " p.post_date,"+
                    " p.likes_count FROM post_tbl p, user u" +
                    " where p.post_user_id = u.user_id" +
                    " and p.post_health = 1" +
                    " and post_user_id in " +
                    "(select person_i_follow_id from my_following_tbl where my_id = '" + userId + "')" +"" +
                    "union " +
                    "SELECT u.full_name, " +
                    "p.post_id," +
                    " p.post_image_url," +
                    " p.post_desc, " +
                    "p.post_lat, " +
                    "p.post_lon, " +
                    "p.post_date," +
                    "p.likes_count FROM post_tbl p, user u " +
                    "where p.post_user_id = u.user_id " +
                    "and p.post_health = 1 " +
                    "and post_user_id = '"+userId+"'" +
                    "ORDER BY post_date DESC";
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
            if (isSaved) saveNotification(post.getUserId());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSaved;
    }

    private void saveNotification(int userId) {
        String getLatestPost = "select max(post_id) from post_tbl where post_user_id = '"+userId+"'";

        try {
            PreparedStatement statement = getConnection().prepareStatement(getLatestPost);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                NotificationDao notificationDao = new NotificationDao();
                int postId = set.getInt("max(post_id)");
                notificationDao.saveNotification(postId, userId);

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
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
            getPreparedStatement(postList, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    private void getPreparedStatement(List<Post> postList, String sql) throws SQLException {
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
    }

    public boolean deletePost(int postId, int userId) {
        boolean deleted = false;
        try {
            String sql = "DELETE from post_tbl WHERE post_id='"+postId+"' " +
                    "and post_user_id = '"+userId+"'";
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

    public int getPostCount() {
        int posts = 0;
        String sql = "select count(post_id) from post_tbl";
        return queryPosts(posts, sql);
    }

    public int getUnhealthyPostCount() {
        int posts = 0;
        String sql = "select count(post_id) from post_tbl WHERE post_health='0'";
        return queryPosts(posts, sql);
    }

    private int queryPosts(int posts, String sql) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                posts = set.getInt("count(post_id)");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
}