package upeu.g1.rest.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class Ms000ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms000ConfigServerApplication.class, args);
	}

}
