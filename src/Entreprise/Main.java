package Entreprise;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import Entreprise.*;
public class Main {
    public static void main(String[] args) throws SQLException {


        Scanner sc = new Scanner(System.in);
        employe E1 = new employe();
        paiement P1 = new paiement();
        administrateur A1 = new administrateur();
        A1.setLogin("Admin");
        A1.setMotDePasse("passer");
        A1.setIdAdmin("A1");
        A1.setPrenom("Soda");
        A1.setNom("SEYE");
//          A1.AfficherAdministrateur(A1);
        System.out.println("✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤");
        System.out.println("┇┇          🅱🅸🅴🅽🆅🅴🅽🆄🅴  🅳🅰🅽🆂  🆅🅾🆃🆁🅴  🆂🆈🆂🆃🅴🅼🅴                                                 ┇┇");
        System.out.println("┇┇                        🅳🅴  🅶🅴🆂🆃🅸🅾🅽  🅳🅴                                                        ┇┇");
        System.out.println("┇┇                            🅿🅰🅸🅴🅼🅴🅽🆃                                                            ┇┇");
        System.out.println("✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤");
        System.out.println("┇┇                                                                                                   ┇┇");
        System.out.println("┇┇                                                                                                   ┇┇");
        System.out.println("┇┇                         𝑨 𝐶 𝐶 𝐸 𝑼 𝑰 𝐿                                                             ┇┇");
        System.out.println("┇┇                                                                                                   ┇┇");
        System.out.println("┇┇                                                                                                   ┇┇");
        System.out.println("┇┇      Etes-vous un :                                                                               ┇┇");
        System.out.println("┇┇                                                                                                   ┇┇");
        System.out.println("┇┇                                                                                                   ┇┇");
        System.out.println("┇┇                      1‑ Administrateur                                                             ┇┇");
        System.out.println("┇┇                                                                                                   ┇┇");
        System.out.println("┇┇                       2- Employe                                                                  ┇┇");
        System.out.println("┇┇                                                                                                   ┇┇");
        System.out.println("┇┇                                                                                                   ┇┇");
        System.out.println("✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤");
        System.out.println("┇┇                                                                                                   ┇┇");
        System.out.println("┇┇  Entrez le numéro de votre choix ( 1 ou 2 ) :                                                     ┇┇");
        System.out.println("┇┇                                                                                                   ┇┇");
        System.out.println("✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤");
        int rep;
        Utilisateur U = new Utilisateur();
        do {
            rep = sc.nextInt();
        } while (rep !=1 && rep != 2);
//        boolean ch;
        U.InitialiserUtilisateur(U);
//        if () ch = true;
//        else ch = false;

        if (rep ==1) {
            if ((A1.getLogin().equals(U.getLogin())) && (A1.getMotDePasse().equals(U.getMotDePasse()))) {
                System.out.println("Vous êtes bien l'administrateur");
                int option;
                do {
                    System.out.println("Que souhaitez-vous?\n 1-Ajouter\n 2-Modifier \n 3-Supprimer \n 4-Consulter l'historique de paiement");
//                    Saisir la date de paiement

                            option = sc.nextInt();

                    switch (option) {
                        case 1:
                            E1.ajouteremploye(E1);
                            break;
                        case 2:
                            E1.ModifierEmploye(E1);
                            break;
                        case 3:
                            E1.SupprimerEmploye(E1);
                            break;
//                        case 4:
//                            P1.InitialiserPaiement(P1);
//                            break;
                        case 4:
                            E1.consulterHistorique(E1);
                    }
                }while ( option !=1 && option != 2 && option != 3 && option != 4 && option != 5);


            } else {
                System.out.println("Vous n'êtes pas l'administrateur");
            }
        } else if (rep ==2 ) {
            System.out.println("si vous etes employe identifier vous!!!");
//            Utilisateur.adminLogin(E1);
            E1.IndentifierEmploye(E1);
            if ((E1.getLogin().equals(U.getLogin())) && (E1.getMotDePasse().equals(U.getMotDePasse()))) {
                System.out.println("Vous pouvez consulter l'état de votre paiement");
                System.out.println("Saisir votre matricule");
                String matricule = sc.next();
                P1.ConsulterPaiement(matricule);

            }else {
                System.out.println("Vous etes pas employer");
            }
        }
    }

}


