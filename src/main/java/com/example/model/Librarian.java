package com.example.model;

import java.util.List;

public class Librarian extends User {

    private Librarian (){};

    public static class Builder{
        private Librarian librarian;
        public Builder(Long ID, String fullName){
            librarian = new Librarian();
            librarian.ID = ID;
            librarian.fullName = fullName;
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
