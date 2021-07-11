package upeu.g1.rest.docente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.g1.rest.docente.entity.Facultad;
import upeu.g1.rest.docente.entity.Sede;
import upeu.g1.rest.docente.repository.FacultadRepository;

@Service
public class FacultadServiceImpl implements FacultadService{
	
	@Autowired
	private FacultadRepository facultadRepository;

	@Override
	public Iterable<Facultad> findAll() {
		return facultadRepository.findAll();
	}

	@Override
	public Facultad getFacultad(Long id) {
		return facultadRepository.findById(id).orElse(null);
	}

	@Override
	public Facultad createFacultad(Facultad facultad) {
		Facultad facultadDB = facultadRepository.findByname(facultad.getName());
		if(facultadDB != null) {
			return facultadDB;
		}
		facultadDB = facultadRepository.save(facultad);
		return facultadDB;
	}

	@Override
	public Facultad save(Facultad facultad) {
		return facultadRepository.save(facultad);
	}

	@Override
	public List<Facultad> findBySede(Sede sede) {
		return facultadRepository.findBySede(sede);
	}

	@Override
	public Facultad updateFacultad(Facultad facultad) {
		Facultad facultadDB = getFacultad(facultad.getId());
		if(null == facultadDB) {
			return null;
		}
		facultadDB.setName(facultad.getName());
		facultadDB.setSede(facultad.getSede());
		return facultadRepository.save(facultad);
	}

}
