package upeu.g1.rest.nomina.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import upeu.g1.rest.nomina.entity.Nomina;


public interface NominaService {

public Iterable<Nomina> findAll();
	
	public Page<Nomina> findAll(Pageable pageable);
	
	public Optional<Nomina> findById(Long id);
	
	public Nomina save(Nomina nomina);
	
	public void deleteById(Long id);
	
}
