package uz.kiuf.questions_answers_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnectionToDatabase() {
        Connection connection = null;

        try {
            // load the driver class
            Class.forName("org.postgresql.Driver");
            System.out.println("Postgresql JDBC Driver Registered!");

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/questions_base", "postgres", "2801");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Postgresql JDBC Driver?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Connection made to DB!");
        }
        return connection;
    }
}
