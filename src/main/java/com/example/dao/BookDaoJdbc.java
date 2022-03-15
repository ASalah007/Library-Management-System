package com.example.dao;

import com.example.model.Author;
import com.example.model.Book;

import com.example.model.BookCopy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookDaoJdbc implements BookDao{
    @Override
    public List<Book> findAllBooks() {
        List<Book> result = new ArrayList<>();

        Connection conn = null;
        try{
            String sql = Files.readString(Path.of(BookDaoJdbc.class.getResource("findAllBooksQuery.sql").getPath()));
            conn = Jdbc.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();


            while(resultSet.next()){
                Set<Author> bookAuthors = new HashSet<>();
                Set<BookCopy> bookCopies = new HashSet<>();

                Book book = new Book.Builder(resultSet.getString("ISBN"), resultSet.getString("title"))
                        .numberOfPages(resultSet.getLong("number_of_pages"))
                        .information(resultSet.getString("book.information"))
                        .build();

                // get the list of author and copies of this book
                do{
                    bookAuthors.add(new Author.Builder(resultSet.getLong("author.ID"),
                            resultSet.getString("full_name"))
                            .information(resultSet.getString("author.information"))
                            .birthDate(resultSet.getDate("author.birthdate"))
                            .build());
                    bookCopies.add(new BookCopy.Builder(resultSet.getLong("book_copy.ID"))
                            .branch(resultSet.getString("branch"))
                            .cost(resultSet.getLong("cost"))
                            .physicalCondition(resultSet.getString("physical_condition"))
                            .build());

                }while(resultSet.next() && resultSet.getString("ISBN") == book.getISBN());

                book.setAuthors(new ArrayList<>(bookAuthors));
                book.setCopies(new ArrayList<>(bookCopies));
                result.add(book);

                if(resultSet.isAfterLast())
                    break;
                resultSet.previous();
            }
            return result;
        }

        catch(IOException ex){
            System.err.println(ex);
            System.err.println("Class: BookDaoJdbc");
            System.err.println("Method: findAllBooks");
            return null;
        }
        catch(SQLException ex){
            System.err.println("something wrong with the sql statement");
            System.err.println("Class: BookDaoJdbc");
            System.err.println("Method: findAllBooks");
            return null;
        }
        finally {
            Jdbc.closeConnection(conn);
        }
    }

    @Override
    public List<Book> findBooksByKeyWord(String keyWord) {
        return null;
    }

    @Override
    public void addBook(Book newBook) {
        // TODO
    }

    @Override
    public void deleteBook(Book book) {
        // TODO
    }

    @Override
    public void updateBook(Book book, String newTitle, String newInformation, Long newNumberOfPages) {
        // TODO
    }
}
