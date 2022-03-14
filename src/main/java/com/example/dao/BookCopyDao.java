package com.example.dao;

import java.util.List;

import com.example.model.Book;
import com.example.model.BookCopy;
import com.example.model.BookCopy.PhysicalCondition;
import com.example.model.Reader;

public interface BookCopyDao {
    List<Book> findAllCopies();

    List<Book> findCopiesByKeyWord(String keyWord);

    void addCopy(BookCopy newCopy);

    void deleteCopy(BookCopy copy);

    void updateCopy(BookCopy copy, Long newCost, PhysicalCondition newCondition, String newBranch);

    void borrowCopy(Reader reader, BookCopy bookCopy);

    void returnCopy(Reader reader, BookCopy bookCopy);
}
