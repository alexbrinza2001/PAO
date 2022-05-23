package com.project.pao.dao.repositories;

import com.project.pao.dao.configuration.DatabaseConfiguration;

import java.sql.*;

public class ReaderRepository {

    private static ReaderRepository readerRepository;

    private ReaderRepository() {
    }

    public static ReaderRepository getReaderRepository () {
        if (readerRepository == null) {
            readerRepository = new ReaderRepository();
        }
        return readerRepository;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS reader" +
                "(readerId int PRIMARY KEY AUTO_INCREMENT, firstName varchar(30), lastName varchar(30), nationality varchar(30), " +
                "gender varchar(30), email varchar(30), phoneNumber varchar(30))";

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
    public void insert(String firstName, String lastName, String nationality, String gender, String email, String phoneNumber) {
        String insertSql = "INSERT INTO reader(firstName, lastName, nationality, gender, email, phoneNumber) VALUES(?, ?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, nationality);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, phoneNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ
    public void select() {
        String selectSql = "SELECT * FROM reader";

        Connection connection = DatabaseConfiguration.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            System.out.println("Readers: ");
            while (resultSet.next()) {
                System.out.println("\tFirst Name: " + resultSet.getString(2));
                System.out.println("\tLast Name: " + resultSet.getString(3));
                System.out.println("\tNationality " + resultSet.getString(4));
                System.out.println("\tGender: " + resultSet.getString(5));
                System.out.println("\tEmail: " + resultSet.getString(6));
                System.out.println("\tPhone Number: " + resultSet.getString(7));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(int readerId, String email) {
        String updateSql = "UPDATE reader SET email=? WHERE readerId=?";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, email);
            preparedStatement.setInt(2, readerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int readerId) {
        String deleteSql = "DELETE FROM reader WHERE readerId=?";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, readerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
