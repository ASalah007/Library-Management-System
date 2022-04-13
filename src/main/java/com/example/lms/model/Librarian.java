package com.example.lms.model;

public class Librarian extends User {

    public Librarian (int ID, String fullName){
        this.ID = ID;
        this.fullName = fullName;
    };

    public static class Builder{
        private Librarian librarian;
        public Builder(int ID, String fullName){
            librarian = new Librarian(ID, fullName);
        }
        public Builder email(String email){
            librarian.email = email;
            return this;
        }
        public Builder password(String password){
            librarian.password = password;
            return this;
        }
        public Librarian build(){
            return librarian;
        }
    }

}
