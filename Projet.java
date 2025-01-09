package models;

import java.util.Date;

public class Projet {
    private int idPrjt;
    private String nomP;
    private String type; // "Formation", "Hackaton", "Atelier"
    private Date dateDebut;
    private Date dateFin;
    private String descriptionProjet;
    private Date dateCreation;
    private String statut; // "En attente", "Validé", "Refusé"
    private int idEnseignant; // ID of the teacher who created the project

    // Getters and Setters
    public int getIdPrjt() {
        return idPrjt;
    }

    public void setIdPrjt(int idPrjt) {
        this.idPrjt = idPrjt;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescriptionProjet() {
        return descriptionProjet;
    }

    public void setDescriptionProjet(String descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }
}
