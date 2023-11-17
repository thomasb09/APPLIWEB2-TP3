package A23.C6.TP3.ServiceREST.tbnh.A23.C6.TP3.ServiceREST.tbnh.modele;

import A23.C6.TP3.ServiceREST.tbnh.A23.C6.TP3.ServiceREST.tbnh.service.CalculCheminService;
import A23.C6.TP3.ServiceREST.tbnh.A23.C6.TP3.ServiceREST.tbnh.service.LectureFichierJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GestionClient {

    private ListClientService listClientService;
    private CalculCheminService calculCheminService;
    private LectureFichierJSON lectureFichierJSON;

    @Autowired
    public GestionClient(ListClientService listClientService, CalculCheminService calculCheminService) {
        this.listClientService = listClientService;
        this.calculCheminService = calculCheminService;
    }
    public String routeDuJour(String route) {
        listClientService.findAll().get(0).setListe(route);
        listClientService.save(listClientService.findAll().get(0));
        return "Nouvelle list " + listClientService.findAll().get(0).getListe();
    }

    public String routeDuJour() {
        return listClientService.findAll().get(0).getListe();
    }

    public String calculerChemin(String listAdresse) {
        return routeDuJour(calculCheminService.calculerChemin(listAdresse).block());
    }

    public List<Client> listClients() {
        return lectureFichierJSON.lireFichierJSON();
    }
}
