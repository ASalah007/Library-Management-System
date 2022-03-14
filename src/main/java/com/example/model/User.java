package com.example.model;

public abstract class User {
    protected Long ID;
    protected String fullName;
    protected String email;
    protected String password;

    public Long getID() {
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
