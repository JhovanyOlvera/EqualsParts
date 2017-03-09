package com.qacg.equalsparts.models;

/**
 * Created by jhovany on 8/03/17.
 */

public class User {

    private String UserName;
    private String Password;

    public User(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
