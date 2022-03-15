package com.example.model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Author {
    private Long ID;
    private String fullName;
    private Date birthDate;
    private String information;

    private List<Book> books;

    public Author(Long ID, String fullName){
        this.ID = ID;
        this.fullName = fullName;
    };
    public Long getID() {
        return ID;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public String getFullName() {
        return fullName;
    }
    public String getInformation() {
        return information;
    }
    public List<Book> getBooks() {
        return books;
    }


    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass())
            return false;

        Author that = (Author) obj;
        if(this.ID != that.ID)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Author: " + this.fullName;
    }

    public static class Builder{
        private Author author;
        public Builder(Long ID, String fullName){
            author = new Author(ID, fullName);
        }

        public Builder birthDate(Date birthDate){
            author.birthDate = birthDate;
            return this;
        }

        public Builder information(String information){
            author.information = information;
            return this;
        }

        public Builder books(List<Book> books){
            author.books = books;
            return this;
        }

        public Author build(){
            return author;
        }
    }
}
