
create database lms;
use lms;
CREATE TABLE reader (
    ID INT AUTO_INCREMENT,
    full_name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    password VARCHAR(500) NOT NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE librarian (
    ID INT AUTO_INCREMENT,
    full_name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    password VARCHAR(500) NOT NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE author (
    ID INT AUTO_INCREMENT,
    full_name VARCHAR(150) NOT NULL,
    birthdate DATE,
    information VARCHAR(2000),
    PRIMARY KEY (ID)
);
CREATE TABLE book (
    ISBN varchar(24) NOT NULL,
    information VARCHAR(2000) NOT NULL,
    title VARCHAR(150) NOT NULL,
    number_of_pages INT NOT NULL,
    PRIMARY KEY (ISBN)
);
CREATE TABLE book_author (
    ID INT,
    ISBN varchar(24),
    FOREIGN KEY (ID)
        REFERENCES author (ID),
    FOREIGN KEY (ISBN)
        REFERENCES book (ISBN),
    PRIMARY KEY (ID , ISBN)
);
CREATE TABLE book_category (
    category_name VARCHAR(150),
    ISBN varchar(24) NOT NULL,
    PRIMARY KEY (ISBN , category_name),
    FOREIGN KEY (ISBN)
        REFERENCES book (ISBN)
);
CREATE TABLE book_copy (
    ID INT AUTO_INCREMENT,
    cost INT NOT NULL,
    physical_condition ENUM('excellent', 'very-good', 'good', 'usable', 'not-usable'),
    PRIMARY KEY (ID)
);
CREATE TABLE book_book_copy (
    ID INT NOT NULL,
    ISBN varchar(24) NOT NULL,
    FOREIGN KEY (ID)
        REFERENCES book_copy (ID),
    FOREIGN KEY (ISBN)
        REFERENCES book (ISBN)
);
CREATE TABLE borrows (
    book_copy_ID INT NOT NULL,
    reader_ID INT NOT NULL,
    due_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (book_copy_ID)
        REFERENCES book_copy (ID),
    FOREIGN KEY (reader_ID)
        REFERENCES reader (ID),
    PRIMARY KEY (book_copy_Id , reader_ID)
);
commit;







