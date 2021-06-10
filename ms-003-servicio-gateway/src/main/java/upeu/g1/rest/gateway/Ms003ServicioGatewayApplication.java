package upeu.g1.rest.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Ms003ServicioGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms003ServicioGatewayApplication.class, args);
	}

}
