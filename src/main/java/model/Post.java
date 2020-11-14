package model;

public class Post {
    String postImageUrl;
    String description;
    int likes;
    int postId;

    public Post(String postImageUrl, String description, int likes) {
        this.postImageUrl = postImageUrl;
        this.description = description;
        this.likes = likes;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getPostId() {
        return postId;
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
