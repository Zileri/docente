package upeu.g1.rest.legajo.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import upeu.g1.rest.legajo.entity.Archivo;
import upeu.g1.rest.legajo.entity.Legajo;
import upeu.g1.rest.legajo.repository.LegajoRepository;

@Service
public class LegajoServiceImpl implements LegajoService{
	
	@Autowired
	private LegajoRepository legajoRepository;

	@Override
	public Iterable<Legajo> findAll() {
		return legajoRepository.findAll();
	}

	@Override
	public Page<Legajo> findAll(Pageable pageable) {
		return legajoRepository.findAll(pageable);
	}

	@Override
	public Optional<Legajo> findById(Long id) {
		return legajoRepository.findById(id);
	}

	@Override
	public Legajo getLegajo(Long id) {
		return legajoRepository.findById(id).orElse(null);
	}

	@Override
	public Legajo save(Legajo legajo) {
		return legajoRepository.save(legajo);
	}

	@Override
	public Legajo deleteArchivo(Long id) {
		return null;
	}

	@Override
	public Legajo updateLegajo(Legajo legajo) {
		Legajo legajoDB = getLegajo(legajo.getId());
		if(null == legajoDB) {
			return null;
		}
		legajoDB.setEstado(true);
		legajoDB.setFecha(legajo.getFecha());
		legajoDB.setNumFolios(legajo.getNumFolios());
		return legajoRepository.save(legajo);
	}

	@Override
	public Legajo createLegajo(Legajo legajo) {
		Legajo legajoDB = legajoRepository.findByname(legajo.getName());
		if(legajoDB != null) {
			return legajoDB;
		}
		legajo.setEstado(true);
		legajoDB = legajoRepository.save(legajo);
		return legajoDB;
	}

}
