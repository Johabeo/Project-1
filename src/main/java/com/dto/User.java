package com.dto;

public class User {
    private int id;
    private String username;
    private String password;
    private String userType;

    public User(int id,String userType,String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
