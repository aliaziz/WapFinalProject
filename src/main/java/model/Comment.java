package model;

public class Comment {
    private int commentId;
    private int postId;
    private int userId;
    private String comment;
    private String fullName;

    public Comment(int postId, int userId, String comment) {
        this.postId = postId;
        this.userId = userId;
        this.comment = comment;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentId() {
        return commentId;
    }

    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public String getComment() {
        return comment;
    }
}
