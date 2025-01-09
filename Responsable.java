package models;

public class Responsable extends Utilisateur {
    private String departement; // The department the responsible is in charge of

    // Getter and Setter
    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
}
