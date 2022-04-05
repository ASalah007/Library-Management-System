package com.example.dao;

import java.util.List;

import com.example.model.Librarian;

public interface LibrarianDao {
    List<Librarian> findAllLibrarians();

    List<Librarian> findLibrariansByKeyWord(String keyWord);

    void addLibrarian(Librarian newLibrarian);

    void deleteLibrarian(Librarian librarian);

    void updateLibrarian(Librarian librarian, String newFullName, String newEmail, String newPassword);

}
