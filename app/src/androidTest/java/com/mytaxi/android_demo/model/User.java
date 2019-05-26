package com.mytaxi.android_demo.model;

public class User {
    private String userId;
    private String password;
    public User (){
        this.userId = "crazydog335" ;
        this.password = "venture";
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
