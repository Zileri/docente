package upeu.g1.rest.docente.service;

import java.util.List;

import upeu.g1.rest.docente.entity.Sede;


public interface SedeService {

	public Iterable<Sede> findAll();

	// public Page<Factor> findAll(Pageable pageable);

	// public Optional<Factor> findById(Long id);

	public Sede getSede(Long id);

	public Sede createSede(Sede sede);

	public Sede save(Sede sede);

	//public Factor deleteFactor(Long id);

	//public List<Factor> findBySeccion(Seccion seccion);

	public Sede updateSede(Sede sede);

	// public void deleteById(Long id);
	
}
