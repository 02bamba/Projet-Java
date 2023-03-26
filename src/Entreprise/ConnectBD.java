package Entreprise;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConnectBD {
    private Connection con;
    private PreparedStatement pst;

    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Projet", "root", "");
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(String mat) {
        try {
            pst = con.prepareStatement("DELETE FROM employe WHERE matricule = ?;");
            pst.setString(1, mat);
            pst.executeUpdate();
            if (pst == null){
                System.out.println("l'utilisateur  n'existe pas");
            }else {
                System.out.println("Suppression reussie !");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void afficherUser(employe E, int choix) throws SQLException {
        Scanner lire = new Scanner(System.in);
        try {
            if (choix == 1) {
                System.out.println("Donner le matricule de l'employé");
                String matricule = lire.next();
                pst = con.prepareStatement("SELECT * FROM employe WHERE matricule = ?;");

                pst.setString(1, E.getMatricule());
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                        System.out.println(" Matricule =" + rs.getString("matricule"));
                        System.out.println("Prénom  = " + rs.getString("prenom"));
                        System.out.println("Nom = " + rs.getString("nom"));
                        System.out.println("Sexe = " + rs.getString("sexe"));
                        System.out.println("Date de naissance = " + rs.getDate("ddn"));
                        System.out.println("Poste = " + rs.getString("poste"));
                        System.out.println("Taux de travail = " + rs.getFloat("T_travail"));
                        System.out.println("Heure de travail = " + rs.getInt("H_travail"));
                        System.out.println("Salaire = " + rs.getFloat("salaire"));
                }
                }else if (choix == 2) {
                pst = con.prepareStatement("SELECT * FROM employe;");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    System.out.println(" Matricule =" + rs.getString("matricule"));
                    System.out.println("Prénom  = " + rs.getString("prenom"));
                    System.out.println("Nom = " + rs.getString("nom"));
                    System.out.println("Sexe = " + rs.getString("sexe"));
                    System.out.println("Date de naissance = " + rs.getDate("ddn"));
                    System.out.println("Poste = " + rs.getString("NomPoste"));
                    System.out.println("Taux de travail = " + rs.getFloat("T_travail"));
                    System.out.println("Heure de travail = " + rs.getInt("H_travail"));
                    System.out.println("Salaire = " + rs.getFloat("salaire"));
                    System.out.println("\n \n");
                }
            } else {
                System.out.println("Employé non trouvé.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void addUser(String nom, String prenom, String login, String motDePasse, LocalDate ddn, String NomPoste, String sexe, float th, float ht,float salaire) throws SQLException {
        pst = con.prepareStatement("SELECT * FROM employe WHERE matricule = ?;");
        pst.setString(1, login);
        pst.executeQuery();
        if (pst == null) {
            System.out.println("l'utilisateur  n'existe pas");
        }else {
            pst = con.prepareStatement("INSERT INTO employe (prenom,nom,ddn,NomPoste,sexe,H_Travail,T_travail,matricule,salaire) VALUES (?,?, ?, ?, ?, ?,?, ?, ?);");
            pst.setString(1, prenom);
            pst.setString(2, nom);
            pst.setDate(3, Date.valueOf(ddn));
            pst.setString(4, NomPoste);
            pst.setString(5,sexe);
            pst.setFloat(6, ht);
            pst.setFloat(7, th);
            pst.setString(8,login );
            pst.setFloat(9,salaire );
            pst.executeUpdate();
            pst = con.prepareStatement("INSERT INTO utilisateur(login,mdp) values(?,?);");
            pst.setString(1,login );
            pst.setString(2,motDePasse);
            pst.executeUpdate();
            System.out.println("Inscription réussie !");
        }
        }


        public void modify(String matricule) throws SQLException {
            pst = con.prepareStatement("SELECT * FROM employe WHERE matricule = ?");
            pst.setString(1, matricule);
            pst.executeQuery();
            if (pst == null) {
                System.out.println("L'employé  n'existe pas !");
            } else {

                Scanner scanner = new Scanner(System.in);
                System.out.print("Nom : ");
                String nom = scanner.nextLine();
                System.out.print("Prénom : ");
                String prenom = scanner.nextLine();
                System.out.print("Matricule : ");
                String login = scanner.nextLine();
                System.out.print("Mot de passe : ");
                String motDePasse = scanner.nextLine();
                System.out.print("Enter votre date naissance: ");
                String date = scanner.nextLine();
                LocalDate ddn = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
                System.out.println("Enter votre nom de poste: ");
                String NomPoste = scanner.nextLine();
                String sexe;
                do {
                    System.out.println("le sexe doit être Masculin ou Féminin SAISIR M OU F");
                    System.out.println("Son sexe:");
                    sexe = scanner.nextLine();
                } while (!(sexe.equals("M")) && !(sexe.equals("F")));

                System.out.println("Taux horaire:");
                float th = scanner.nextFloat();
                System.out.println("Heure de travail:");
                float ht = scanner.nextFloat();

                float salaire =th*ht;

                pst = con.prepareStatement("UPDATE employe SET prenom=?, nom=?, ddn=?, NomPoste=?, sexe=?, H_Travail=?, T_travail=?, salaire=? WHERE matricule=?");
                pst.setString(1, prenom);
                pst.setString(2, nom);
                pst.setDate(3, Date.valueOf(ddn));
                pst.setString(4, NomPoste);
                pst.setString(5, sexe);
                pst.setDouble(6, th);
                pst.setDouble(7, ht);
                pst.setDouble(8,salaire);
                pst.setString(9,login);
                pst.executeUpdate();
                pst = con.prepareStatement("UPDATE utilisateur SET login=?, mdp=? Where idEmp = ?");
                pst.setString(1,login);
                pst.setString(2,motDePasse);
                pst.setString(3,matricule);
                pst.executeUpdate();
                System.out.println("Modification  réussie !");
            }

        }

        public void consulter(String matricule) throws SQLException {

            pst = con.prepareStatement("SELECT * FROM employe WHERE matricule = ?;");

            pst.setString(1, matricule);
            ResultSet rs = pst.executeQuery();
            if (rs == null){
                System.out.println("l'utilisateur  n'existe pas");
            }else {
                pst = con.prepareStatement("select matricule,nom,prenom,date_p,salaire from  employe,paiment where ( idEmp = matricule ) AND matricule =?;");
                pst.setString(1, matricule);
                rs = pst.executeQuery();

                while (rs.next()) {
                    System.out.println(" \n\nMatricule =" + rs.getString("matricule"));
                    System.out.println("Prénom  = " + rs.getString("prenom"));
                    System.out.println("Nom = " + rs.getString("nom"));
                    System.out.println("Date de paiement = " + rs.getDate("date_p"));
                    System.out.println("Salaire = " + rs.getFloat("salaire"));
                }
            }
        }
    public void close() {
        try {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
            System.out.println("Déconnexion réussie !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



















//    public  void deletUser(String mat){
//        try {
//            pst = con.prepareStatement("DROP from employe WHERE matricule = ?");
//            pst.setString(1,mat);
//            pst.executeQuery();
//            if (pst == null){
//                System.out.println("l'utilisateur  n'existe pas");
//            }else {
//                System.out.println("Suppression reussie !");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
