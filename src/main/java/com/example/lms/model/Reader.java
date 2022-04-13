package com.example.lms.model;

import java.util.List;

public class Reader extends User {

    private List<BookCopy> bookCopies;
    private double fees;

    public Reader(int ID, String fullName){
        this.ID = ID;
        this.fullName = fullName;
    };
    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }
    public double getFees() {
        return fees;
    }

    public static class Builder{
        private Reader reader;

        public Builder(int ID, String fullName){
            reader = new Reader(ID,fullName);
        }
        public Builder email(String email){
            reader.email = email;
            return this;
        }

        public Builder password(String password){
            reader.password = password;
            return this;
        }
        public Builder bookCopies(List<BookCopy> copies){
            reader.bookCopies = copies;
            return this;
        }

        public Builder fees(Long fees){
            reader.fees = fees;
            return this;
        }

        public Reader build(){
            return reader;
        }
    }
}
