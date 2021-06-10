package upeu.arapa.rest.docente.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import upeu.arapa.rest.docente.models.entity.Docente;
import upeu.arapa.rest.docente.models.service.IDocenteService;


@RestController
public class DocenteController {

	@Value("${server.port}")
	private Integer port;
	
	@Autowired //para inyectar clase service
	private IDocenteService docenteService;
	
	@GetMapping("/listar")
	public List<Docente> listar(){
		return docenteService.findAll().stream().map(docente ->{
			docente.setPort(port);
			return docente;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Docente detalle(@PathVariable Long id) {
		Docente docente = docenteService.findById(id);
		docente.setPort(port);
		return docente;
	}
	
}
