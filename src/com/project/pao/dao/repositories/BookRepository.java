package com.project.pao.dao.repositories;
import com.project.pao.dao.configuration.DatabaseConfiguration;

import java.sql.*;


public class BookRepository {

    private static BookRepository bookRepository;

    private BookRepository() {
    }

    public static BookRepository getBookRepository() {
        if (bookRepository == null) {
            bookRepository = new BookRepository();
        }
        return bookRepository;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS book" +
                "(bookId int PRIMARY KEY AUTO_INCREMENT, name varchar(30), genre varchar(30), authorLastName varchar(30), " +
                "yearPublished int, description varchar(150), returnLimit int, loaned bit)";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //CREATE - INSERT, READ - SELECT, UPDATE, DELETE

    //INSERT
    public void insert(String name, String genre, String authorLastName, int yearPublished, String description, int returnLimit, boolean loaned) {
        String insertSql = "INSERT INTO book(name, genre, authorLastName, yearPublished, description, returnLimit, loaned) VALUES(?, ?, ?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, genre);
            preparedStatement.setString(3, authorLastName);
            preparedStatement.setInt(4, yearPublished);
            preparedStatement.setString(5, description);
            preparedStatement.setInt(6, returnLimit);
            preparedStatement.setBoolean(7, loaned);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ
    public void select() {
        String selectSql = "SELECT * FROM book";

        Connection connection = DatabaseConfiguration.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            System.out.println("Books: ");
            while (resultSet.next()) {
                System.out.println("\tName: " + resultSet.getString(2));
                System.out.println("\tGenre: " + resultSet.getString(3));
                System.out.println("\tAuthor Last Name: " + resultSet.getString(4));
                System.out.println("\tYear Published: " + resultSet.getInt(5));
                System.out.println("\tDescription: " + resultSet.getString(6));
                System.out.println("\tReturn Limit: " + resultSet.getInt(7));
                System.out.println("\tLoaned: " + resultSet.getBoolean(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(int bookId, boolean loaned) {
        String updateSql = "UPDATE book SET loaned=? WHERE bookId=?";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setBoolean(1, loaned);
            preparedStatement.setInt(2, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int bookId) {
        String deleteSql = "DELETE FROM book WHERE bookId=?";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
