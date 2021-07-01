package upeu.g1.rest.evaluacion.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import upeu.g1.rest.evaluacion.entity.Seccion;

public interface SeccionService {

	public Iterable<Seccion> findAll();
	
	//public Page<Seccion> findAll(Pageable pageable);
	
	//public Optional<Seccion> findById(Long id);
	
	public Seccion save(Seccion seccion);
	
	public Seccion getSeccion(Long id);
	
	public Seccion createSeccion(Seccion seccion);
	
	public Seccion updateSeccion(Seccion seccion);
	
	//public void deleteById(Long id);
}
