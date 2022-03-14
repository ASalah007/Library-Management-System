package com.example.model;

import java.util.List;
import java.util.Objects;

public class Book {
    private String ISBN;
    private String information;
    private String title;
    private Long numberOfPages;

    private List<Author> authors;
    private List<BookCopy> copies;

    private Book(){};

    public String getTitle() {
        return title;
    }
    public String getInformation() {
        return information;
    }
    public Long getNumberOfPages() {
        return numberOfPages;
    }
    public String getISBN() {
        return ISBN;
    }

    public void setAuthors(List<Author> authors){
        this.authors = authors;
    }
    public List<Author> getAuthors() {
        return authors;
    }

    public void setCopies(List<BookCopy> copies){
        this.copies = copies;
    }
    public List<BookCopy> getCopies() {
        return copies;
    }


    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Book that = (Book) obj;
        if(this.ISBN != that.ISBN)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book: "+ title;
    }

    public static class Builder{
        private Book book;
        public Builder(String ISBN, String title){
            book = new Book();
            book.ISBN = ISBN;
            book.title = title;
        }
        public Builder information(String information){
            book.information = information;
            return this;
        }

        public Builder numberOfPages(Long numberOfPages){
            book.numberOfPages = numberOfPages;
            return this;
        }

        public Builder authors(List<Author> authors){
            book.authors = authors;
            return this;
        }

        public Builder copies(List<BookCopy> copies){
            book.copies = copies;
            return this;
        }

        public Book build(){
            return book;
        }
    }
}