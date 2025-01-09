package database;

import java.sql.*;

public class DatabaseConnection {

    // Method to establish and return the database connection
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/projet_management";  // Update with your database details
        String username = "root";  // Update with your username
        String password = "";      // Update with your password

        return DriverManager.getConnection(url, username, password);
    }
}
