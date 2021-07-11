package upeu.g1.rest.docente.service;

import java.util.List;

import upeu.g1.rest.docente.entity.Facultad;
import upeu.g1.rest.docente.entity.Sede;


public interface FacultadService {

	public Iterable<Facultad> findAll();

	// public Page<Factor> findAll(Pageable pageable);

	// public Optional<Factor> findById(Long id);

	public Facultad getFacultad(Long id);

	public Facultad createFacultad(Facultad facultad);

	public Facultad save(Facultad facultad);

	//public Factor deleteFactor(Long id);

	public List<Facultad> findBySede(Sede sede);

	public Facultad updateFacultad(Facultad facultad);

	// public void deleteById(Long id);
	
}
