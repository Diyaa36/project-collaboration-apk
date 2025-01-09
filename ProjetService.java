package services;

import models.Projet;
import database.ProjetDAO;
import java.util.List;

public class ProjetService {

    // Method to create a new project
    public void createProjet(Projet projet) {
        ProjetDAO projetDAO = new ProjetDAO();
        projetDAO.addProjet(projet);
    }

    // Method to get all projects
    public List<Projet> getAllProjets() {
        ProjetDAO projetDAO = new ProjetDAO();
        return projetDAO.getAllProjets();
    }

    // Method to validate a project by a responsible
    public void validateProjet(int projetId) {
        ProjetDAO projetDAO = new ProjetDAO();
        projetDAO.updateProjetStatus(projetId, "Validé");
    }

    // Method to reject a project by a responsible
    public void rejectProjet(int projetId) {
        ProjetDAO projetDAO = new ProjetDAO();
        projetDAO.updateProjetStatus(projetId, "Refusé");
    }
}
