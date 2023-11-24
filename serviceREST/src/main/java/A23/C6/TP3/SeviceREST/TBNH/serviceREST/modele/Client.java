package A23.C6.TP3.SeviceREST.TBNH.serviceREST.modele;

public class Client {

    private String nom;
    private String adresse;
    private String lat;
    private String lng;

    public Client(String nom, String adresse, String lat, String lng) {
        this.nom = nom;
        this.adresse = adresse;
        this.lat = lat;
        this.lng = lng;
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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
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
