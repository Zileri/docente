package upeu.g1.rest.legajo.controller;

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
import upeu.g1.rest.legajo.entity.Archivo;
import upeu.g1.rest.legajo.service.ArchivoService;

@Slf4j
@RestController
@RequestMapping("/api/archivos")
public class ArchivoController {

	@Autowired
	private ArchivoService archivoService;

	// create

	/*@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Archivo archivo, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(archivoService.save(archivo));
	}*/
	
	@PostMapping
	public ResponseEntity<Archivo> create(@Valid @RequestBody Archivo archivo, BindingResult result){
		log.info("creando archivo: {}", archivo);
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
		}
		Archivo archivoDB = archivoService.createArchivo(archivo);
		return ResponseEntity.status(HttpStatus.CREATED).body(archivoDB);
	}
	

	// read
	/*
	 * @GetMapping("/{id}") public ResponseEntity<?> read(@PathVariable(value =
	 * "id") Long archivoId) { Optional<Archivo> oArchivo =
	 * archivoService.findById(archivoId);
	 * 
	 * if (!oArchivo.isPresent()) { return ResponseEntity.notFound().build(); }
	 * 
	 * return ResponseEntity.ok(oArchivo); }
	 */

	// update

	/*@PutMapping("/{id}")
	public ResponseEntity<Archivo> update(Long id, @RequestBody Archivo archivo) {
		archivo.setId(id);
		Archivo archivoDB = archivoService.updateArchivo(archivo);
		if (archivoDB == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(archivoDB);
	}*/

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") Long archivoId, @RequestBody Archivo archivoDetails) {
		log.info("actualizando el archivo con id {}", archivoId);
		Archivo archivo =archivoService.getArchivo(archivoId);
		if(null == archivo) {
			log.error("No se puedee actualizar. Archivo con id {} no encontrado", archivoId);
			return ResponseEntity.notFound().build();
		}
		archivoDetails.setId(archivoId);
		archivo=archivoService.updateArchivo(archivo);
		return ResponseEntity.ok(archivo);
	}
	
	
	
	// delete
	
	 @DeleteMapping("/{id}") 
	 public ResponseEntity<Archivo>
	 delete(@PathVariable(value = "id") Long archivoId) { Archivo delete =
	 archivoService.deleteArchivo(archivoId); if (delete == null) { return
	 ResponseEntity.notFound().build(); }
	 
	 return ResponseEntity.ok().build(); }
	 

	// read
	@GetMapping
	public List<Archivo> readAll() {

		List<Archivo> archivos = StreamSupport.stream(archivoService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return archivos;
	}
	
	//read por id
	@GetMapping(value="/{id}")
	public ResponseEntity<Archivo> getArchivo(@PathVariable("id") long id){
		log.info("Obteniendo archivo con id {}", id);
		Archivo archivo = archivoService.getArchivo(id);
		if(null == archivo) {
			log.error("archivo con id {} no encontrado", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(archivo);
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
