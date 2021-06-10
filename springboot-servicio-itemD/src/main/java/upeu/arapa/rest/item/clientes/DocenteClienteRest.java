package upeu.arapa.rest.item.clientes;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import upeu.arapa.rest.item.models.Docente;


@FeignClient(name = "servicio-docentes")
public interface DocenteClienteRest {
	
	@GetMapping("/listar")
	public List<Docente> listar();
	
	@GetMapping("/ver/{id}")
	public Docente detalle(@PathVariable Long id);

}
