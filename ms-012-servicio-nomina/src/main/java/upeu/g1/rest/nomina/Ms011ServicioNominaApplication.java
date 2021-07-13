package upeu.g1.rest.nomina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class Ms011ServicioNominaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms011ServicioNominaApplication.class, args);
	}

}
