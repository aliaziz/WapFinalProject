package model;

public class Post {
    String postImageUrl;
    String description;
    String posterFullName;
    String postDate;
    double postLat;
    double postLong;
    int likes;
    int postId;
    int userId;
    int postHealth;

    public Post(String postImageUrl, String description, int likes, int userId, double postLat, double postLong) {
        this.postImageUrl = postImageUrl;
        this.description = description;
        this.likes = likes;
        this.userId = userId;
        this.postLat = postLat;
        this.postLong = postLong;
    }

    public int getPostHealth() {
        return postHealth;
    }

    public void setPostHealth(int postHealth) {
        this.postHealth = postHealth;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getPosterFullName() {
        return posterFullName;
    }

    public void setPosterFullName(String posterFullName) {
        this.posterFullName = posterFullName;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public int getLikes() {
        return likes;
    }

    public double getPostLat() {
        return postLat;
    }

    public double getPostLong() {
        return postLong;
    }
}
