package A23.C6.TP3.ClientLogistique.tbnh.A23.C6.TP3.ClientLogistique.tbnh;

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
