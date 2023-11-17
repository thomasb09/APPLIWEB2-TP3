package A23.C6.TP3.ServiceREST.tbnh.A23.C6.TP3.ServiceREST.tbnh;

import A23.C6.TP3.ServiceREST.tbnh.A23.C6.TP3.ServiceREST.tbnh.modele.GestionClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceREST {
    private GestionClient gestionClient;

    public ServiceREST(GestionClient gestionClient) {
        this.gestionClient = gestionClient;
    }

    @GetMapping("/routeDuJour")
    public String routeDuJour() {
        return gestionClient.routeDuJour();
    }

    @PostMapping("/routeDuJour")
    public ResponseEntity<String> routeDuJour(@RequestBody String route) {
        gestionClient.calculerChemin(route);
        return ResponseEntity.ok().build();
    }
}
