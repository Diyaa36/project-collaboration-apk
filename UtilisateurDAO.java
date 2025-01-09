package database;

import models.Utilisateur;
import java.sql.*;

public class UtilisateurDAO {

    private Connection connection;

    // Constructor to establish a database connection
    public UtilisateurDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get a user by email
    public Utilisateur getUtilisateurByEmail(String email) {
        String query = "SELECT * FROM Utilisateur WHERE email_user = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            
            if (resultSet.next()) {
                Utilisateur user = new Utilisateur();
                user.setIdUser(resultSet.getInt("id_user"));
                user.setNomUser(resultSet.getString("nom_user"));
                user.setPrenomUser(resultSet.getString("prenom_user"));
                user.setEmailUser(resultSet.getString("email_user"));
                user.setTeleUser(resultSet.getString("tele_user"));
                user.setAdresseUser(resultSet.getString("adresse_user"));
                user.setPasswordUser(resultSet.getString("password_user"));
                user.setTypeUser(resultSet.getString("type_user"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no user is found
    }
}
