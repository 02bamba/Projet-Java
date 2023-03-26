package Entreprise;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class employe extends  Utilisateur {
    private String Matricule;
    private String prenom;
    private String nom;
    private LocalDate DateDeNaissance;
    private String NomPoste;
    private Sexe sexe;
    private Double H_travail;
    private Double T_travail;

    private Double salaire;
    private administrateur gerant;

    public employe() {
    }

    public employe(String pLogin, String pMotDePasse, String vMatricule, String vPrenom, String vNom, LocalDate vDateDeNaissance, String vNomPoste, Sexe vSexe,
                   Double vH_travail, Double vT_travail, Double vSalaire, administrateur vGerant) {
        super(pLogin, pMotDePasse);
        Matricule = vMatricule;
        prenom = vPrenom;
        nom = vNom;
        DateDeNaissance = vDateDeNaissance;
        NomPoste = vNomPoste;
        H_travail = vH_travail;
        T_travail = vT_travail;
        gerant = vGerant;

    }

    public String getMatricule() {
        return Matricule;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getDateDeNaissance() {
        return DateDeNaissance;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public String getNomPoste() {
        return NomPoste;
    }

    public Double getH_travail() {
        return H_travail;
    }

    public Double getT_travail() {
        return T_travail;
    }

    public Double getSalaire() {
        return salaire;
    }

    public administrateur getGerant() {
        return gerant;
    }

    public void setMatricule(String matricule) {
        Matricule = matricule;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateDeNaissance(LocalDate DDN) {
        DateDeNaissance = DDN;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public void setNomPoste(String nomPoste) {
        NomPoste = nomPoste;
    }

    public void setH_travail(Double h_travail) {
        H_travail = h_travail;
    }

    public void setT_travail(Double t_travail) {
        T_travail = t_travail;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public void setGerant(administrateur gerant) {
        this.gerant = gerant;
    }

    public static void CalculerSalaire(Double H_travail, Double T_travail) {
        Double salaire = H_travail * T_travail;
        System.out.println("Son salaire est:" + salaire);
    }

    public static void IndentifierEmploye(employe E) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Son login");
        String login = sc.next();
        E.setLogin(login);
        System.out.println("Son mot de passe");
        String MotDePasse = sc.next();
        E.setMotDePasse(MotDePasse);

    }


    public static void ajouteremploye(employe E) throws SQLException {

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
//                String gerant="admin";
        ConnectBD connecion = new ConnectBD();
        connecion.connect();
        connecion.addUser(nom, prenom, login, motDePasse, ddn, NomPoste, sexe, th, ht,th*ht);
    }

        public static void consulterHistorique (employe E) throws SQLException {
            Scanner lire = new Scanner(System.in);
            System.out.println("Vous souhaitez consulter l'historique de paiment pour:");
            System.out.println("1-Pour un employé");
            System.out.println("2-Pour plusieurs employés");
            int choix = lire.nextInt();
            ConnectBD connexion = new ConnectBD();
            connexion.connect();
            connexion.afficherUser(E, choix);
            connexion.close();
        }
        public static void ModifierEmploye(employe E) throws SQLException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Saisissez l'identifiant de l'employé");
            String matricule = sc.next();
            ConnectBD connexion = new ConnectBD();
            connexion.connect();
            connexion.modify(matricule);
            connexion.close();
        }

        public void SupprimerEmploye (employe E) throws SQLException {

            Scanner sc = new Scanner(System.in);
            System.out.println("Saisissez le matricule de l'employé");
            String matricule = sc.next();
            ConnectBD connexion = new ConnectBD();
            connexion.connect();
            connexion.deleteUser(matricule);
            connexion.close();
        }
}
