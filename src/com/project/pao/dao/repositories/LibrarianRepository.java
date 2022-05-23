package com.project.pao.dao.repositories;

import com.project.pao.dao.configuration.DatabaseConfiguration;

import java.sql.*;

public class LibrarianRepository {

    private static LibrarianRepository librarianRepository;

    private LibrarianRepository() {
    }

    public static LibrarianRepository getLibrarianRepository() {
        if (librarianRepository == null) {
            librarianRepository = new LibrarianRepository();
        }
        return librarianRepository;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS librarian" +
                "(librarianId int PRIMARY KEY AUTO_INCREMENT, firstName varchar(30), lastName varchar(30), nationality varchar(30), " +
                "gender varchar(30), salary int, numberOfHoursAWeek int)";

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
    public void insert(String firstName, String lastName, String nationality, String gender, int salary, int numberOfHoursAWeek) {
        String insertSql = "INSERT INTO librarian(firstName, lastName, nationality, gender, salary, numberOfHoursAWeek) VALUES(?, ?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, nationality);
            preparedStatement.setString(4, gender);
            preparedStatement.setInt(5, salary);
            preparedStatement.setInt(6, numberOfHoursAWeek);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ
    public void select() {
        String selectSql = "SELECT * FROM librarian";

        Connection connection = DatabaseConfiguration.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            System.out.println("Librarians: ");
            while (resultSet.next()) {
                System.out.println("\tFirst Name: " + resultSet.getString(2));
                System.out.println("\tLast Name: " + resultSet.getString(3));
                System.out.println("\tNationality " + resultSet.getString(4));
                System.out.println("\tGender: " + resultSet.getString(5));
                System.out.println("\tSalary: " + resultSet.getInt(6));
                System.out.println("\tNumber Of Hours A Week: " + resultSet.getInt(7));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(int librarianId, int salary) {
        String updateSql = "UPDATE librarian SET salary=? WHERE librarianId=?";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setInt(1, salary);
            preparedStatement.setInt(2, librarianId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int librarianId) {
        String deleteSql = "DELETE FROM librarian WHERE librarianId=?";

        Connection connection = DatabaseConfiguration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, librarianId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
