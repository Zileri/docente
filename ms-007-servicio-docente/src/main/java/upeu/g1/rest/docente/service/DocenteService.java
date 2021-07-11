package upeu.g1.rest.docente.service;

import java.util.List;

import upeu.g1.rest.docente.entity.Docente;
import upeu.g1.rest.docente.entity.Escuela;


public interface DocenteService {

	public Iterable<Docente> findAll();

	// public Page<Factor> findAll(Pageable pageable);

	// public Optional<Factor> findById(Long id);

	public Docente getDocente(Long id);

	public Docente createDocente(Docente docente);

	public Docente save(Docente docente);

	//public Factor deleteFactor(Long id);

	public List<Docente> findByEscuela(Escuela escuela);

	public Docente updateDocente(Docente docente);

	// public void deleteById(Long id);
	
}
