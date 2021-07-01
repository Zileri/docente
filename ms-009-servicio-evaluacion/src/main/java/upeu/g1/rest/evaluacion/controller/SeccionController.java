package upeu.g1.rest.evaluacion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import upeu.g1.rest.evaluacion.entity.Seccion;
import upeu.g1.rest.evaluacion.service.SeccionService;

@Slf4j
@RestController
@RequestMapping("/api/secciones")
public class SeccionController {

	@Autowired
	private SeccionService seccionService;

	// create a new section
	@PostMapping
	public ResponseEntity<Seccion> create(@Valid @RequestBody Seccion seccion, BindingResult result){
		log.info("creando seccion: {}", seccion);
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
		}
		Seccion seccionDB = seccionService.createSeccion(seccion);
		return ResponseEntity.status(HttpStatus.CREATED).body(seccionDB);
	}

	// read an section
	/*@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long seccionId) {
		Optional<Seccion> oSeccion = seccionService.findById(seccionId);

		if (!oSeccion.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(oSeccion);
	}*/

	// update an section
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Seccion seccionDetails, @PathVariable(value = "id") Long seccionId) {
		log.info("actualizando la seccion con id {}", seccionId);
		Seccion seccion = seccionService.getSeccion(seccionId);
		if(null == seccion) {
			log.error("No se puede actualizar. Seccion con id {} no encontrado", seccionId);
			return ResponseEntity.notFound().build();
		}
		seccionDetails.setId(seccionId);
		seccion=seccionService.updateSeccion(seccion);
		return ResponseEntity.ok(seccion);
	}

	// delete an section

	

	// read all sections
	@GetMapping
	public List<Seccion> readAll() {

		List<Seccion> secciones = StreamSupport.stream(seccionService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return secciones;
	}

	private String formatMessage(BindingResult result) {
		List<Map<String, String>> erros = result.getFieldErrors().stream().map(err -> {
			Map<String, String> error = new HashMap<>();
			error.put(err.getField(), err.getDefaultMessage());
			return error;
		}).collect(Collectors.toList());
		ErrorMensaje errorMensaje = ErrorMensaje.builder().code("01").messages(erros).build();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(errorMensaje);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}

}
