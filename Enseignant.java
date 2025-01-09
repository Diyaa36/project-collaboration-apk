package models;

public class Enseignant extends Utilisateur {
    private String specialite; // The specialty of the teacher

    // Getter and Setter
    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
