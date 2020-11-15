package model;

public class Post {
    String postImageUrl;
    String description;
    String posterFullName;
    int likes;
    int postId;
    int userId;

    public Post(String postImageUrl, String description, int likes, int userId) {
        this.postImageUrl = postImageUrl;
        this.description = description;
        this.likes = likes;
        this.userId = userId;
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
}
