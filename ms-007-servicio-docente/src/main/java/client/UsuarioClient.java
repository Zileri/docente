package client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Usuario;



@FeignClient(name = "usuario-service")
@RequestMapping("/api/usuarios")
public interface UsuarioClient {

	@GetMapping(value="/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") long id);
	
}
