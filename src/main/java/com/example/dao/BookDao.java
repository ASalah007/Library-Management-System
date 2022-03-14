package com.example.dao;

import java.util.List;

import com.example.model.Book;

public interface BookDao {
    List<Book> findAllBooks();

    List<Book> findBooksByKeyWord(String keyWord);

    void addBook(Book newBook);

    void deleteBook(Book book);

    void updateBook(Book book, String newTitle, String newInformation, Long newNumberOfPages);
}
