package upeu.g1.rest.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class Ms001ServicioEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms001ServicioEurekaServerApplication.class, args);
	}

}
