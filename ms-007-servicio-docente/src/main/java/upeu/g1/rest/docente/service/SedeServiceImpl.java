package upeu.g1.rest.docente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.g1.rest.docente.entity.Sede;
import upeu.g1.rest.docente.repository.SedeRepository;

@Service
public class SedeServiceImpl implements SedeService{
	
	@Autowired 
	private SedeRepository sedeRepository;

	@Override
	public Iterable<Sede> findAll() {
		return sedeRepository.findAll();
	}

	@Override
	public Sede getSede(Long id) {
		return sedeRepository.findById(id).orElse(null);
	}

	@Override
	public Sede createSede(Sede sede) {
		Sede sedeDB = sedeRepository.findByname(sede.getName());
		if(sedeDB != null) {
			return sedeDB;
		}
		sedeDB = sedeRepository.save(sede);
		return sedeDB;
	}

	@Override
	public Sede save(Sede sede) {
		return sedeRepository.save(sede);
	}

	@Override
	public Sede updateSede(Sede sede) {
		Sede sedeDB = getSede(sede.getId());
		if(null == sedeDB) {
			return null;
		}
		sedeDB.setName(sede.getName());
		return sedeRepository.save(sede);
	}

}
