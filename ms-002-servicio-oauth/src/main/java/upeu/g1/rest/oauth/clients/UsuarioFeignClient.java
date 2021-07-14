package upeu.g1.rest.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import upeu.g1.rest.usuariocommons.entity.Usuario;


@FeignClient(name = "servicio-usuarios")
public interface UsuarioFeignClient {

	@GetMapping("/usuarios/search/buscar-username")
	public Usuario findByName(@RequestParam String name); 
	
}
