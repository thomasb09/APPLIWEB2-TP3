package A23.C6.TP3.SeviceREST.TBNH.serviceREST.modele;

public class Client {

    private String nom;
    private String adresse;

    public Client(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public Client(){

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
