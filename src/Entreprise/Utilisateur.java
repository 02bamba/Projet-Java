package Entreprise;

import java.sql.*;
import java.util.Scanner;

public class Utilisateur {
    protected String login;
    protected String MotDePasse;


    public Utilisateur (){}
    public Utilisateur(String vlogin, String vMotDePasse){
        login = vlogin;
        MotDePasse= vMotDePasse;
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setLogin(String login) {
        this.login = login;

    }

    public void setMotDePasse(String motDePasse) {
        MotDePasse = motDePasse;
    }
        public static void InitialiserUtilisateur(Utilisateur U){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir les données de l'utilisateur");
        System.out.println("Son login");
        String login = sc.next();
        U.setLogin(login);
        System.out.println("Son mot de passe");
        String MotDePasse = sc.next();
        U.setMotDePasse(MotDePasse);

    }


    public static boolean adminLogin(Utilisateur U) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre nom d'utilisateur : ");
        String username = scanner.nextLine();
        System.out.print("Entrez votre mot de passe : ");
        String password = scanner.nextLine();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isAdmin = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Projet", "root", "");
            pstmt = conn.prepareStatement("SELECT * FROM utilisateur WHERE login = ? AND mdp = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                isAdmin = true;
                System.out.println("Bienvenue " + username + " !");
            } else {
                System.out.println("Nom d'utilisateur ou mot de passe invalide.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }

        return isAdmin;
    }

}
