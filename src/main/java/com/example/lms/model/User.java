package com.example.lms.model;

public abstract class User {
    protected int ID;
    protected String fullName;
    protected String email;
    protected String password;

    public int getID() {
        return ID;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }


}
