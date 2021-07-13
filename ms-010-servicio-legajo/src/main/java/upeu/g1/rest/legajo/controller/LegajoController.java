package upeu.g1.rest.legajo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import upeu.g1.rest.legajo.entity.Archivo;
import upeu.g1.rest.legajo.entity.Legajo;
import upeu.g1.rest.legajo.service.ArchivoService;
import upeu.g1.rest.legajo.service.LegajoService;

@Slf4j
@RestController
@RequestMapping("/api/legajos")
public class LegajoController {

	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private LegajoService legajoService;	

	// create

	@PostMapping
	public ResponseEntity<Legajo> create(@Valid @RequestBody Legajo legajo, BindingResult result){
		log.info("creando legajo: {}", legajo);
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
		}
		Legajo legajoDB = legajoService.createLegajo(legajo);
		return ResponseEntity.status(HttpStatus.CREATED).body(legajoDB);
	}

	
	// read
	@GetMapping
	public List<Legajo> readAll() {

		List<Legajo> legajos = StreamSupport.stream(legajoService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return legajos;
	}
	
	
	// update

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Legajo legajoDetails, @PathVariable(value = "id") Long legajoId) {
		log.info("actualizando el legajo con id {}", legajoId);

		Legajo legajo =legajoService.getLegajo(legajoId);
		if(null == legajo) {
			log.error("No se puedee actualizar. Legajo con id {} no encontrado", legajoId);
			return ResponseEntity.notFound().build();
		}
		legajoDetails.setId(legajoId);
		legajo=legajoService.updateLegajo(legajo);
		return ResponseEntity.ok(legajo);
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
