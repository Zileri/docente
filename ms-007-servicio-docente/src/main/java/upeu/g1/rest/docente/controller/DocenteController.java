package upeu.g1.rest.docente.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import upeu.g1.rest.docente.entity.Docente;
import upeu.g1.rest.docente.service.DocenteService;

@Slf4j
@RestController
@RequestMapping("/api/docentes")
public class DocenteController {
	
	@Autowired
	private DocenteService docenteService;
	
	@PostMapping
	public ResponseEntity<Docente> create(@Valid @RequestBody Docente docente, BindingResult result){
		log.info("creando docente: {}", docente);
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
		}
		Docente docenteDB = docenteService.createDocente(docente);
		return ResponseEntity.status(HttpStatus.CREATED).body(docenteDB);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Docente docenteDetails, @PathVariable(value = "id") Long docenteId) {
		log.info("actualizando docente con id {}", docenteId);

		Docente docente = docenteService.getDocente(docenteId);
		if (null == docente) {
			log.error("No se puede actualizar. docente con id {} no encontrado", docenteId);
			return ResponseEntity.notFound().build();
		}
		docenteDetails.setId(docenteId);
		docente=docenteService.updateDocente(docente);
		return ResponseEntity.ok(docente);
	}
	
	@GetMapping
	public List<Docente> readAll() {

		List<Docente> docentes = StreamSupport.stream(docenteService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return docentes;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Docente> get(@PathVariable("id") long id){
		log.info("Obteniendo docente con id {}", id);
		Docente docente = docenteService.getDocente(id);
		if(null == docente) {
			log.error("docente con id {} no encontrado", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(docente);
	}
	
	
	private String formatMessage(BindingResult result) {
		List<Map<String, String>> erros = result.getFieldErrors().stream()
				.map(err ->{
					Map<String, String> error = new HashMap<>();
					error.put(err.getField(), err.getDefaultMessage());
					return error;
				}).collect(Collectors.toList());
		ErrorMensaje errorMensaje = ErrorMensaje.builder()
				.code("01")
				.messages(erros).build();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString="";
		try {
			jsonString = mapper.writeValueAsString(errorMensaje);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}

}
