package database;

import models.Projet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDAO {

    private Connection connection;

    // Constructor to establish a database connection
    public ProjetDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new project
    public void addProjet(Projet projet) {
        String query = "INSERT INTO Projet (nomP, type, description_projet, date_creation, statut, id_enseignant) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, projet.getNomP());
            stmt.setString(2, projet.getType());
            stmt.setString(3, projet.getDescriptionProjet());
            stmt.setDate(4, new java.sql.Date(projet.getDateCreation().getTime()));
            stmt.setString(5, projet.getStatut());
            stmt.setInt(6, projet.getIdEnseignant());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get all projects
    public List<Projet> getAllProjets() {
        List<Projet> projets = new ArrayList<>();
        String query = "SELECT * FROM Projet";
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                Projet projet = new Projet();
                projet.setIdPrjt(resultSet.getInt("id_prjt"));
                projet.setNomP(resultSet.getString("nomP"));
                projet.setType(resultSet.getString("type"));
                projet.setDescriptionProjet(resultSet.getString("description_projet"));
                projet.setDateCreation(resultSet.getDate("date_creation"));
                projet.setStatut(resultSet.getString("statut"));
                projet.setIdEnseignant(resultSet.getInt("id_enseignant"));
                projets.add(projet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projets;
    }

    // Method to update the project status (e.g., validate or reject)
    public void updateProjetStatus(int projetId, String statut) {
        String query = "UPDATE Projet SET statut = ? WHERE id_prjt = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, statut);
            stmt.setInt(2, projetId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
