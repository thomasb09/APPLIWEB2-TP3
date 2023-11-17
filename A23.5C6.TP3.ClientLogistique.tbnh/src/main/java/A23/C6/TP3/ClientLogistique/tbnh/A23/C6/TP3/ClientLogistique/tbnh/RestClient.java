package A23.C6.TP3.ClientLogistique.tbnh.A23.C6.TP3.ClientLogistique.tbnh;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class RestClient {

    private static final String BASE_URL = "http://172.20.45.21:8080/a23.form.9.war-0.0.1-SNAPSHOT"; // Replace with your actual server URL

    /**
     * CODE NON FONCTIONNELLE< EXEMPLE POUR LA SUITE
        MANQUE INTERFACE GRAPHIQUE MVC
     * @param args
     */
    public static void main(String[] args) {
        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Test GET endpoint: /routeDuJour
        int personIdToRetrieve = 1;
        ListClient retrievedPerson = restTemplate.getForObject(BASE_URL + "/routeDuJour/" + personIdToRetrieve, ListClient.class);
        System.out.println("Retrieved list: " + retrievedPerson.getListClient());

        // Test POST endpoint: /personne
        ListClient newPerson = new ListClient();
        ResponseEntity<String> postResponse = restTemplate.postForEntity(BASE_URL + "/personne", newPerson, String.class);
        System.out.println("Post Response: " + postResponse.getBody());

    }
}
