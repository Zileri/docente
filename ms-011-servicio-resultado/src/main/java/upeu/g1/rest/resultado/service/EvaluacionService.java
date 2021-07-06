package upeu.g1.rest.resultado.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import upeu.g1.rest.resultado.entity.Evaluacion;


public interface EvaluacionService {

	public Iterable<Evaluacion> findAll();
	
	//public Page<Evaluacion> findAll(Pageable pageable);
	
	public Optional<Evaluacion> findById(Long id);
	
	public Evaluacion save(Evaluacion evaluacion);
	
	public Evaluacion getEvaluacion(Long id);
	
	public Evaluacion updateEvaluacion(Evaluacion evaluacion);
	
	public void deleteById(Long id);
	
}
