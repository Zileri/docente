package upeu.g1.rest.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
public class Ms013ServicioUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms013ServicioUsersApplication.class, args);
	}

}
