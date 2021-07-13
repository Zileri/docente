package client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Nomina;


@FeignClient(name = "nomina-service")
@RequestMapping("/api/nominas")
public interface NominaClient {

	@GetMapping(value="/{id}")
	public ResponseEntity<Nomina> getNomina(@PathVariable("id") long id);
	
}
