package model;

public class Notification {
    int notificationId;
    int userId;
    int postId;
    String postSummary;
    String posterFullName;

    public Notification(int notificationId, int userId, int postId) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.postId = postId;
    }

    public String getPosterFullName() {
        return posterFullName;
    }

    public void setPosterFullName(String posterFullName) {
        this.posterFullName = posterFullName;
    }

    public void setPostSummary(String postSummary) {
        this.postSummary = postSummary;
    }

    public String getPostSummary() {
        return postSummary;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public int getUserId() {
        return userId;
    }

    public int getPostId() {
        return postId;
    }
}
