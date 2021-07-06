package upeu.g1.rest.legajo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Ms010ServicioLegajoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms010ServicioLegajoApplication.class, args);
	}

}
