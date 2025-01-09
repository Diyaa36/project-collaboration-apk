package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.Projet;
import services.ProjetService;

public class ResponsableController {

    @FXML
    private Button validateButton;

    @FXML
    private Button rejectButton;

    private int selectedProjetId;  // ID of the selected project to validate or reject

    // Method to handle project validation
    @FXML
    private void handleValidateProject() {
        ProjetService projetService = new ProjetService();
        projetService.validateProjet(selectedProjetId);

        // Show success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Project Validated");
        alert.setHeaderText("The project has been validated.");
        alert.setContentText("The project is now available for student applications.");
        alert.showAndWait();
    }

    // Method to handle project rejection
    @FXML
    private void handleRejectProject() {
        ProjetService projetService = new ProjetService();
        projetService.rejectProjet(selectedProjetId);

        // Show success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Project Rejected");
        alert.setHeaderText("The project has been rejected.");
        alert.setContentText("The project will not be available for student applications.");
        alert.showAndWait();
    }

    // Method to set the selected project ID for validation/rejection
    public void setSelectedProjetId(int projetId) {
        this.selectedProjetId = projetId;
    }
}
