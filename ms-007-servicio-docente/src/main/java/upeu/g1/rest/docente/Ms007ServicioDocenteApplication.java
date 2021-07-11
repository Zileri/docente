package upeu.g1.rest.docente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class Ms007ServicioDocenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms007ServicioDocenteApplication.class, args);
	}

}
