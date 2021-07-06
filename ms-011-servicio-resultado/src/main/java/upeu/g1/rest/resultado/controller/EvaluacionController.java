package upeu.g1.rest.resultado.controller;

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
import upeu.g1.rest.resultado.entity.Evaluacion;
import upeu.g1.rest.resultado.service.EvaluacionService;

@Slf4j
@RestController
@RequestMapping("/api/resultados")
public class EvaluacionController {

	@Autowired
	private EvaluacionService evaluacionService;

	// create
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Evaluacion evaluacion) {
		return ResponseEntity.status(HttpStatus.CREATED).body(evaluacionService.save(evaluacion));
	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Evaluacion evaluacionDetails,
			@PathVariable(value = "id") Long evaluacionId) {
		log.info("actualizando resultado con id {}", evaluacionId);
		Evaluacion evaluacion = evaluacionService.getEvaluacion(evaluacionId);
		if(null == evaluacion) {
			log.error("No se puede actualizar. Resultado con id {} no encontrado", evaluacionId);
			return ResponseEntity.notFound().build();
		}
		evaluacionDetails.setId(evaluacionId);
		evaluacion=evaluacionService.updateEvaluacion(evaluacion);
		return ResponseEntity.ok(evaluacion);
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long evaluacionId) {
		if (!evaluacionService.findById(evaluacionId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		evaluacionService.deleteById(evaluacionId);
		return ResponseEntity.ok().build();
	}

	// read
	@GetMapping
	public List<Evaluacion> readAll() {

		List<Evaluacion> evaluaciones = StreamSupport.stream(evaluacionService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return evaluaciones;
	}

	// read por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Evaluacion> getEvaluacion(@PathVariable("id") long id) {
		log.info("Obteniendo archivo con id {}", id);
		Evaluacion evaluacion = evaluacionService.getEvaluacion(id);
		if (null == evaluacion) {
			log.error("archivo con id {} no encontrado", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(evaluacion);
	}

}
