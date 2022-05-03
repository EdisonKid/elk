package com.elk.elkweb.entity;

/**
 * @author Edison
 * @create 2022-04-30 16:48
 */
public class User {
    String USER_NAME;
    String USER_PSD;

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PSD() {
        return USER_PSD;
    }

    public void setUSER_PSD(String USER_PSD) {
        this.USER_PSD = USER_PSD;
    }

    public User() {
    }

    public User(String USER_NAME, String USER_PSD) {
        this.USER_NAME = USER_NAME;
        this.USER_PSD = USER_PSD;
    }

    @Override
    public String toString() {
        return "User{" +
                "USER_NAME='" + USER_NAME + '\'' +
                ", USER_PSD='" + USER_PSD + '\'' +
                '}';
    }
}
