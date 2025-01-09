package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.Projet;
import services.ProjetService;
import java.util.Date;

public class EnseignantController {

    @FXML
    private TextField nomProjetField;

    @FXML
    private TextField typeProjetField;

    @FXML
    private TextField descriptionField;

    @FXML
    private Button createProjectButton;

    // Method to handle project creation
    @FXML
    private void handleCreateProject() {
        String nomProjet = nomProjetField.getText();
        String typeProjet = typeProjetField.getText();
        String description = descriptionField.getText();
        
        // Create the project object
        Projet projet = new Projet();
        projet.setNomP(nomProjet);
        projet.setType(typeProjet);
        projet.setDescriptionProjet(description);
        projet.setDateCreation(new Date()); // Use current date
        projet.setStatut("En attente"); // Default status
        projet.setIdEnseignant(1); // Assuming teacher ID is 1 for now

        // Save the project
        ProjetService projetService = new ProjetService();
        projetService.createProjet(projet);

        // Show success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Project Created");
        alert.setHeaderText("Project has been successfully created.");
        alert.setContentText("The project is now pending validation.");
        alert.showAndWait();
    }
}
