package com.example.dao;

import java.sql.Date;
import java.util.List;

import com.example.model.Author;

public interface AuthorDao {
    List<Author> findAllAuthors();

    List<Author> findAuthrosByKeyWord(String keyWord);

    void addAuthor(Author newAuthor);

    void deleteAuthor(Author author);

    void updateAuthor(Author author, String newFullName, Date newBirthDate, String newInformation);
}
