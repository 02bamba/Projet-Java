package Entreprise;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class paiement {
    private LocalDate Date_P;
    private Double montant;
    public paiement(){}
    public  paiement(LocalDate vDate_P, Double vMontant){
        Date_P =vDate_P;
        montant= vMontant;
    }

    public LocalDate getDate_P() {
        return Date_P;
    }

    public Double getMontant() {
        return montant;
    }

    public void setDate_P(LocalDate date_P) {
        Date_P = date_P;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
    public static void InitialiserPaiement(paiement P){
        Scanner sc = new Scanner(System.in);
        System.out.println("Date de paiement");
        String date = sc.next() ;
        LocalDate Date_P = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        P.setDate_P(Date_P);
        System.out.println("Le montant");
        Double Montant= sc.nextDouble();
        P.setMontant(Montant);
    }
    public static void  ConsulterPaiement(String matricule) {;
        ConnectBD connexion = new ConnectBD();
        connexion.connect();
        try {
            connexion.consulter(matricule);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        System.out.println();
    }
}
