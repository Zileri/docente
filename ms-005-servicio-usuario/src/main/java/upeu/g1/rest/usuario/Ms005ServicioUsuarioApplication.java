package upeu.g1.rest.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class Ms005ServicioUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms005ServicioUsuarioApplication.class, args);
	}

}
