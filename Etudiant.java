package models;

public class Etudiant extends Utilisateur {
    private String niveau; // Level of study, for example: Bachelor, Master, etc.

    // Getter and Setter
    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}
