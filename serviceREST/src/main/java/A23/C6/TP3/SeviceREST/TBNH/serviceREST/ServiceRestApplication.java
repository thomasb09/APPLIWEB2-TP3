package A23.C6.TP3.SeviceREST.TBNH.serviceREST;

import A23.C6.TP3.SeviceREST.TBNH.serviceREST.service.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRestApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		return new CorsFilter();
	}
}
