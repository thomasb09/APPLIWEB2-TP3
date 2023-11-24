package A23.C6.TP3.SeviceREST.TBNH.serviceREST.service;

import A23.C6.TP3.SeviceREST.TBNH.serviceREST.modele.Client;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class CalculCheminService {

    private WebClient webClient = null;

    @Autowired
    public CalculCheminService(WebClient.Builder webClientBuilder) {
        //https://www.graphhopper.com/blog/2017/10/23/how-to-use-the-routing-api-in-java/
        this.webClient = webClientBuilder.baseUrl("https://graphhopper.com").build();
    }

    public String calculerChemin(List<Client> listClient) {

        String retour = "";
        String listClientString = "";
        for(int i = 0; i < listClient.size(); i++) {
            listClientString += "{\n" +
                    "      \"id\": \"" + listClient.get(i).getNom() + "\",\n" +
                    "      \"type\": \"service\",\n" +
                    "      \"address\": {\n" +
                    "        \"location_id\": \"" + listClient.get(i).getNom() + "\",\n" +
                    "        \"lat\": " + listClient.get(i).getLat() + ",\n" +
                    "        \"lon\": " + listClient.get(i).getLng() + "\n" +
                    "      },\n" +
                    "      \"duration\": 120\n }";
                    if(i != listClient.size() - 1) {
                        listClientString += ",\n";
                    }
                    else {
                        listClientString += "\n";
                    }
        }


        String jsonBody = "{\n" +
                "  \"configuration\": {\n" +
                "    \"routing\": {\n" +
                "      \"calc_points\": true,\n" +
                "      \"return_snapped_waypoints\": true\n" +
                "    }\n" +
                "  },\n" +
                "  \"objectives\": [\n" +
                "    {\n" +
                "      \"type\": \"min\",\n" +
                "      \"value\": \"completion_time\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"vehicles\": [\n" +
                "    {\n" +
                "      \"vehicle_id\": \"v1\",\n" +
                "      \"type_id\": \"custom_vehicle_type\",\n" +
                "      \"start_address\": {\n" +
                "        \"location_id\": \"v1\",\n" +
                "        \"lat\": 45.512530,\n" +
                "        \"lon\": -73.406750\n" +
                "      },\n" +
                "      \"earliest_start\": 1508839200,\n" +
                "      \"return_to_depot\": true\n" +
                "    }\n" +
                "  ],\n" +
                "  \"vehicle_types\": [\n" +
                "    {\n" +
                "      \"type_id\": \"custom_vehicle_type\",\n" +
                "      \"profile\": \"car\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"services\": [\n" +
                    listClientString +
                "  ]\n" +
                "}";

        HttpClient httpClient = HttpClient.newHttpClient();


        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://graphhopper.com/api/1/vrp" + "?key=f49aa2d5-f21e-4fe8-a47b-c78435c0daff"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

            try {
                ObjectMapper objectMapper = new ObjectMapper();

                JsonNode jsonNode = objectMapper.readTree(response.body());

                JsonNode routesNode = jsonNode.get("solution").get("routes");
                for (JsonNode route : routesNode) {
                    String vehicleId = route.get("vehicle_id").asText();
                    System.out.println("Route for vehicle " + vehicleId + ":");

                    JsonNode activitiesNode = route.get("activities");
                    int i = 1;
                    for (JsonNode activity : activitiesNode) {
                        String activityType = activity.get("type").asText();
                        if (activityType.equals("service")) {
                            String activityId = activity.get("id").asText();
                            System.out.println("  Activity Type: " + activityType);
                            System.out.println("  Activity ID: " + activityId);
                            retour += "Client no " + i++ + activityId + "\n";
                        }

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retour;
    }
}
