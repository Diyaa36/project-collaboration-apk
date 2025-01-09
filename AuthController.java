package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Utilisateur;
import services.AuthService;

public class AuthController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    // Method to handle login action
    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        AuthService authService = new AuthService();
        Utilisateur user = authService.authenticate(email, password);

        if (user != null) {
            // Redirect to the appropriate interface based on user type
            try {
                Stage stage = (Stage) loginButton.getScene().getWindow();
                FXMLLoader loader;

                if (user.getTypeUser().equals("Etudiant")) {
                    // Load Etudiant interface
                    loader = new FXMLLoader(getClass().getResource("/views/etudiant_interface.fxml"));
                } else if (user.getTypeUser().equals("Enseignant")) {
                    // Load Enseignant interface
                    loader = new FXMLLoader(getClass().getResource("/views/enseignant_interface.fxml"));
                } else if (user.getTypeUser().equals("Responsable")) {
                    // Load Responsable interface
                    loader = new FXMLLoader(getClass().getResource("/views/responsable_interface.fxml"));
                } else {
                    throw new IllegalStateException("Unexpected user type: " + user.getTypeUser());
                }

                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle(user.getTypeUser() + " Dashboard");
                stage.show();
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
                showError("Failed to load the user interface. Please try again later.");
            }
        } else {
            // Show an error message if authentication fails
            showError("Invalid credentials. Please check your email and password.");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText("Authentication failed");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
