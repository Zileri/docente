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
import upeu.g1.rest.evaluacion.entity.Factor;
import upeu.g1.rest.evaluacion.service.FactorService;

@Slf4j
@RestController
@RequestMapping("/api/factors")
public class FactorController {

	@Autowired
	private FactorService factorService;

	// create a new factor
	@PostMapping
	public ResponseEntity<Factor> create(@Valid @RequestBody Factor factor, BindingResult result){
		log.info("creando factor: {}", factor);
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
		}
		Factor factorDB = factorService.createFactor(factor);
		return ResponseEntity.status(HttpStatus.CREATED).body(factorDB);
	}

	// read an factor
	/*@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long factorId) {
		Optional<Factor> oFactor = factorService.findById(factorId);

		if (!oFactor.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(oFactor);
	}*/

	// update an factor
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Factor factorDetails, @PathVariable(value = "id") Long factorId) {
		log.info("actualizando factor con id {}", factorId);

		Factor factor = factorService.getFactor(factorId);
		if (null == factor) {
			log.error("No se puede actualizar. Factor con id {} no encontrado", factorId);
			return ResponseEntity.notFound().build();
		}
		factorDetails.setId(factorId);
		factor=factorService.updateFactor(factor);
		return ResponseEntity.ok(factor);
	}

	// delete an factor
	
	

	// read all factors
	@GetMapping
	public List<Factor> readAll() {

		List<Factor> factors = StreamSupport.stream(factorService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return factors;
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Factor> get(@PathVariable("id") long id){
		log.info("Obteniendo factor con id {}", id);
		Factor factor = factorService.getFactor(id);
		if(null == factor) {
			log.error("factor con id {} no encontrado", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(factor);
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
