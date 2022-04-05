SELECT 
    *
FROM
    book
        JOIN
    book_author USING (ISBN)
        JOIN
    author USING (ID)
        JOIN
    book_book_copy USING (ISBN)
        JOIN
    book_copy ON (book_copy.ID = book_book_copy.ID);