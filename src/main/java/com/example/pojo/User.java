package com.example.pojo;

public class User {
    // 用户id
    private String id;

    // 用户姓名
    private String username;

    // 用户密码
    private String password;

    // 用户身份，0：普通用户，1：管理员，2：超级管理员
    private int identity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", identity=" + identity +
                '}';
    }
}
