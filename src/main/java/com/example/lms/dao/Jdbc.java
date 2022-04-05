package com.example.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            System.err.println("Couldn't load jdbc.driver class");
        }
    }

    static Connection getConnection() throws IOException{
        Connection conn =null;
        try{
             conn = DriverManager.getConnection("jdbc:mysql://localhost::3306/lms","lms", "lms");
        }
        catch(SQLException ex){
            System.err.println("couldn't open connection with mysql database");
            throw new IOException();
        }
        return conn;
    }

    static void closeConnection(Connection conn){
        if(conn == null)
            return;

        try{
            conn.close();
        }
        catch(SQLException ex){
            System.err.println("Couldn't close the connection with mysql database");
        }
    }
}
