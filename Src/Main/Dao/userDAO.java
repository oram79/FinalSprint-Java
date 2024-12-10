package Src.Main.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Src.Main.Models.User;
import Src.Main.Utils.DatabaseConnection;
// Connecting the class to the database
public class UserDAO {
    private Connection connection;

    public UserDAO() {
        connection = DatabaseConnection.getConnection();
    }
}

// Creating a new user //
public void createUser(User user) {
    String sql = "INSERT INTO Users (username, password, email, role) VALUES (?, ?, ?, ?)";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getRole());
        stmt.executeUpdate();
    } catch (SQLException e ) {
        e.printStackTrace();
    }
}
