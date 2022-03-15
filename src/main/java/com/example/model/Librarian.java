package com.example.model;

import java.util.List;

public class Librarian extends User {

    public Librarian (Long ID, String fullName){
        this.ID = ID;
        this.fullName = fullName;
    };

    public static class Builder{
        private Librarian librarian;
        public Builder(Long ID, String fullName){
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
