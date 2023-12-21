package com.example.efeed.model;

public class Model1 {
    private String title;
    private String createdAt;
    private String closedAt;
    private UserModel user;

    public Model1(String title, String createdAt, String closedAt, UserModel user) {
        this.title = title;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
