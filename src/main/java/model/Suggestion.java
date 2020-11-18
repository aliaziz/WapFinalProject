package model;

public class Suggestion {
    String fullName;
    int userId;

    public Suggestion(String fullName, int userId) {
        this.fullName = fullName;
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getUserId() {
        return userId;
    }
}
