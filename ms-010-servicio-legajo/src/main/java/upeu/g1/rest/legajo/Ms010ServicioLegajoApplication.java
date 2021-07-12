package upeu.g1.rest.legajo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
public class Ms010ServicioLegajoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms010ServicioLegajoApplication.class, args);
	}

}
