package upeu.arapa.rest.docente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioDocenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioDocenteApplication.class, args);
	}

}
