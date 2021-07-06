package upeu.g1.rest.nomina.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import upeu.g1.rest.nomina.entity.Nomina;
import upeu.g1.rest.nomina.service.NominaService;

@Slf4j
@RestController
@RequestMapping("/api/nominas")
public class NominaController {

	@Autowired
	private NominaService nominaService;

	// create 
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Nomina nomina) {
		return ResponseEntity.status(HttpStatus.CREATED).body(nominaService.save(nomina));
	}

	// read 
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long nominaId) {
		Optional<Nomina> oNomina = nominaService.findById(nominaId);

		if (!oNomina.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(oNomina);
	}

	// update 
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Nomina nominaDetails, @PathVariable(value = "id") Long nominaId) {
		Optional<Nomina> nomina = nominaService.findById(nominaId);

		if (!nomina.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(nominaDetails, nomina.get());

		return ResponseEntity.status(HttpStatus.CREATED).body(nominaService.save(nomina.get()));
	}

	// delete 
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long nominaId) {
		if (!nominaService.findById(nominaId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		nominaService.deleteById(nominaId);
		return ResponseEntity.ok().build();
	}

	// read 
	@GetMapping
	public List<Nomina> readAll() {

		List<Nomina> nominas = StreamSupport.stream(nominaService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return nominas;
	}
}
