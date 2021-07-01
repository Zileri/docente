package upeu.g1.rest.legajo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import upeu.g1.rest.legajo.entity.Legajo;

public interface LegajoService {

public Iterable<Legajo> findAll();
	
	public Page<Legajo> findAll(Pageable pageable);
	
	public Optional<Legajo> findById(Long id);
	
	//public List<Archivo> listAllArchivo();
	
	public Legajo getLegajo(Long id);
	
	public Legajo createLegajo(Legajo legajo);
	
	public Legajo save(Legajo legajo);
	
	public Legajo deleteArchivo(Long id);
	
	//public List<Archivo> findByLegajo(Legajo legajo);
	
	public Legajo updateLegajo(Legajo legajo);
	
}
