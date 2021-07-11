package upeu.g1.rest.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class Ms004ServicioUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms004ServicioUsuariosApplication.class, args);
	}

}
