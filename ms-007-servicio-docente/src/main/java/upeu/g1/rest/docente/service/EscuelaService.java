package upeu.g1.rest.docente.service;

import java.util.List;

import upeu.g1.rest.docente.entity.Escuela;
import upeu.g1.rest.docente.entity.Facultad;

public interface EscuelaService {

	public Iterable<Escuela> findAll();

	// public Page<Factor> findAll(Pageable pageable);

	// public Optional<Factor> findById(Long id);

	public Escuela getEscuela(Long id);

	public Escuela createEscuela(Escuela escuela);

	public Escuela save(Escuela escuela);

	//public Factor deleteFactor(Long id);

	public List<Escuela> findByFacultad(Facultad facultad);

	public Escuela updateEscuela(Escuela escuela);

	// public void deleteById(Long id);
	
}
