package upeu.g1.rest.docente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.g1.rest.docente.entity.Escuela;
import upeu.g1.rest.docente.entity.Facultad;
import upeu.g1.rest.docente.repository.EscuelaRepository;

@Service
public class EscuelaServiceImpl implements EscuelaService{
	
	@Autowired
	private EscuelaRepository escuelaRepository;

	@Override
	public Iterable<Escuela> findAll() {
		return escuelaRepository.findAll();
	}

	@Override
	public Escuela getEscuela(Long id) {
		return escuelaRepository.findById(id).orElse(null);
	}

	@Override
	public Escuela createEscuela(Escuela escuela) {
		Escuela escuelaDB = escuelaRepository.findByname(escuela.getName());
		if(escuelaDB != null) {
			return escuelaDB;
		}
		escuelaDB = escuelaRepository.save(escuela);
		return escuelaDB;
	}

	@Override
	public Escuela save(Escuela escuela) {
		return escuelaRepository.save(escuela);
	}

	@Override
	public List<Escuela> findByFacultad(Facultad facultad) {
		return escuelaRepository.findByFacultad(facultad);
	}

	@Override
	public Escuela updateEscuela(Escuela escuela) {
		Escuela escuelaDB = getEscuela(escuela.getId());
		if(null == escuelaDB) {
			return null;
		}
		escuelaDB.setName(escuela.getName());
		escuelaDB.setFacultad(escuela.getFacultad());
		return escuelaRepository.save(escuela);
	}
	
}
