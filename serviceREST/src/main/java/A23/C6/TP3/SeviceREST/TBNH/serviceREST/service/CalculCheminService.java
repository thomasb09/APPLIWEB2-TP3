package A23.C6.TP3.SeviceREST.TBNH.serviceREST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CalculCheminService {

    private final WebClient webClient = null;

    @Autowired
    public CalculCheminService(WebClient.Builder webClientBuilder) {
        //https://www.graphhopper.com/blog/2017/10/23/how-to-use-the-routing-api-in-java/
//        this.webClient = webClientBuilder.baseUrl("http://TODO").build();
    }

    public String calculerChemin(String listAdresse) {
//        return webClient.get()
//                .uri("/TODO")
//                .retrieve()
//                .bodyToMono(String.class).block();
        return "";
    }
}
