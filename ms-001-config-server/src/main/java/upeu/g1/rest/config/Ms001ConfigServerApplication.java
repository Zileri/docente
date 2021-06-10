package upeu.g1.rest.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class Ms001ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms001ConfigServerApplication.class, args);
	}

}
