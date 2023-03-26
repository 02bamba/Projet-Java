package Entreprise;


import java.util.Scanner;

public class administrateur extends Utilisateur {
    private String IdAdmin;
    private String Prenom;
    private String nom;

    public administrateur() {
    }

    public administrateur(String vLogin, String vMotDePasse, String vIdAmin, String vPrenom, String vNom) {
        super(vLogin, vMotDePasse);
        IdAdmin = vIdAmin;
        Prenom = vPrenom;
        nom = vNom;
    }

    public String getIdAdmin() {
        return IdAdmin;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setIdAdmin(String idAdmin) {
        IdAdmin = idAdmin;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static void AfficherAdministrateur(administrateur A) {
        System.out.println("L'administateur \t\t\t\t Identifiant  \t\t\t\t  Prénom \t\t\t\t  Nom ");
        System.out.println(" \t\t\t\t     \t\t\t\t" + A.getIdAdmin() + " \t\t\t\t\t\t\t " + A.getPrenom() + "  \t\t\t\t\t" + A.getNom() + "");



    }
}
