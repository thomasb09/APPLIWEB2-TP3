package A23.C6.TP3.ServiceREST.tbnh.A23.C6.TP3.ServiceREST.tbnh.modele;

public class Client {

    private String nom;
    private String adresse;

    public Client(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
