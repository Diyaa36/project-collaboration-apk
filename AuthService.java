package services;

import models.Utilisateur;
import database.UtilisateurDAO;

public class AuthService {

    // Method to authenticate the user
    public Utilisateur authenticate(String email, String password) {
        // Use the DAO to find the user by email
        UtilisateurDAO userDAO = new UtilisateurDAO();
        Utilisateur user = userDAO.getUtilisateurByEmail(email);

        // Check if the user exists and the password matches
        if (user != null && user.getPasswordUser().equals(password)) {
            return user;  // Authentication successful
        }

        return null;  // Authentication failed
    }
}
