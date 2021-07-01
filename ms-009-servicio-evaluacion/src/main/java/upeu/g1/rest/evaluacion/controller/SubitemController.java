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
import upeu.g1.rest.evaluacion.entity.Subitem;
import upeu.g1.rest.evaluacion.service.SubitemService;

@Slf4j
@RestController
@RequestMapping("/api/subitems")
public class SubitemController {

	@Autowired
	private SubitemService subitemService;

	// create a new subitem
	@PostMapping
	public ResponseEntity<Subitem> create(@Valid @RequestBody Subitem subitem, BindingResult result){
		log.info("creando subitem: {}", subitem);
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
		}
		Subitem subitemDB = subitemService.createSubitem(subitem);
		return ResponseEntity.status(HttpStatus.CREATED).body(subitemDB);
	}

	// read an subitem
	/*@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long subitemId) {
		Optional<Subitem> oSubitem = subitemService.findById(subitemId);

		if (!oSubitem.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(oSubitem);
	}*/

	// update an subitem
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Subitem subitemDetails, @PathVariable(value = "id") Long subitemId) {
		log.info("actualizando subitem con id {}", subitemId);
		Subitem subitem=subitemService.getSubitem(subitemId);
		if(null == subitem) {
			log.error("No se puede actualizar. Subitem con id {} no encontrado", subitemId);
			return ResponseEntity.notFound().build();
		}
		subitemDetails.setId(subitemId);
		subitem=subitemService.updateSubitem(subitem);
		return ResponseEntity.ok(subitem);
	}

	// delete an subitem
	
	

	// read all subitems
	@GetMapping
	public List<Subitem> readAll() {

		List<Subitem> subitems = StreamSupport.stream(subitemService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return subitems;
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
