package com.example.dao;

import java.util.List;

import com.example.model.Reader;

public interface ReaderDao {
    List<Reader> findAllReaders();

    List<Reader> findReadersByKeyWord(String keyWord);

    void addReader(Reader newReader);

    void deleteReader(Reader reader);

    void updateReader(Reader reader, String newName, String newEmail, String newPassword);

}
