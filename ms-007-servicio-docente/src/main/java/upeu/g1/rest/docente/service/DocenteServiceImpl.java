package upeu.g1.rest.docente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.g1.rest.docente.entity.Docente;
import upeu.g1.rest.docente.entity.Escuela;
import upeu.g1.rest.docente.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService{
	
	@Autowired
	private DocenteRepository docenteRespository;

	@Override
	public Iterable<Docente> findAll() {
		return docenteRespository.findAll();
	}

	@Override
	public Docente getDocente(Long id) {
		return docenteRespository.findById(id).orElse(null);
	}

	@Override
	public Docente createDocente(Docente docente) {
		Docente docenteDB = docenteRespository.findByname(docente.getName());
		if(docenteDB != null) {
			return docenteDB;
		}
		docenteDB = docenteRespository.save(docente);
		return docenteDB;
	}

	@Override
	public Docente save(Docente docente) {
		return docenteRespository.save(docente);
	}

	@Override
	public List<Docente> findByEscuela(Escuela escuela) {
		return docenteRespository.findByEscuela(escuela);
	}

	@Override
	public Docente updateDocente(Docente docente) {
		Docente docenteDB = getDocente(docente.getId());
		if(null == docenteDB) {
			return null;
		}
		docenteDB.setName(docente.getName());
		docenteDB.setLastName(docente.getLastName());
		docenteDB.setGradoAcademico(docente.getGradoAcademico());
		docenteDB.setFecha(docente.getFecha());
		docenteDB.setEmail(docente.getEmail());
		docenteDB.setDni(docente.getDni());
		docenteDB.setCategoria(docente.getCategoria());
		docenteDB.setDireccion(docente.getDireccion());
		docenteDB.setEscuela(docente.getEscuela());
		docenteDB.setEstado(true);
		return docenteRespository.save(docente);
	}

}
