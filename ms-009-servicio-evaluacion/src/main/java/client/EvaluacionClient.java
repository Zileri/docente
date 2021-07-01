package client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Evaluacion;

@FeignClient(name = "resultado-service")
@RequestMapping("/api/resultados")
public interface EvaluacionClient {

	@GetMapping(value = "/{id}")
	public ResponseEntity<Evaluacion> getEvaluacion(@PathVariable("id") long id);
	
}
