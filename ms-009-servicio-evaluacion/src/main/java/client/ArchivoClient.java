package client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Archivo;

@FeignClient(name = "archivo-service")
@RequestMapping("/api/archivos")
public interface ArchivoClient {
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Archivo> getArchivo(@PathVariable("id") long id);
	
}
