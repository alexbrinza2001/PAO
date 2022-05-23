package com.project.pao.dao.repositories;

import com.project.pao.dao.configuration.DatabaseConfiguration;

import java.sql.*;

public class AuthorRepository {

    private static AuthorRepository authorRepository;

    private AuthorRepository() {
    }

    public static AuthorRepository getAuthorRepository() {
        if (authorRepository == null) {
            authorRepository = new AuthorRepository();
        }
        return authorRepository;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS author" +
                "(authorId int PRIMARY KEY AUTO_INCREMENT, firstName varchar(30), lastName varchar(30), nationality varchar(30), " +
                "gender varchar(30), genre varchar(30), mostFamousTitle varchar(30), yearsActive int)";

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
    public void insert(String firstName, String lastName, String nationality, String gender, String genre, String mostFamousTitle, int yearsActive) {
        String insertSql = "INSERT INTO author(firstName, lastName, nationality, gender, genre, mostFamousTitle, yearsActive) VALUES(?, ?, ?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, nationality);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, genre);
            preparedStatement.setString(6, mostFamousTitle);
            preparedStatement.setInt(7, yearsActive);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ
    public void select() {
        String selectSql = "SELECT * FROM author";

        Connection connection = DatabaseConfiguration.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            System.out.println("Authors: ");
            while (resultSet.next()) {
                System.out.println("\tFirst Name: " + resultSet.getString(2));
                System.out.println("\tLast Name: " + resultSet.getString(3));
                System.out.println("\tNationality " + resultSet.getString(4));
                System.out.println("\tGender: " + resultSet.getString(5));
                System.out.println("\tGenre: " + resultSet.getString(6));
                System.out.println("\tMost Famous Title: " + resultSet.getString(7));
                System.out.println("\tYears Active: " + resultSet.getInt(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(int authorId, int yearsActive) {
        String updateSql = "UPDATE author SET yearsActive=? WHERE authorId=?";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setInt(1, yearsActive);
            preparedStatement.setInt(2, authorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //    private Integer bookId name  genre authorLastName yearPublished description returnLimit loaned;
    // DELETE
    public void delete(int authorId) {
        String deleteSql = "DELETE FROM author WHERE authorId=?";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, authorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
