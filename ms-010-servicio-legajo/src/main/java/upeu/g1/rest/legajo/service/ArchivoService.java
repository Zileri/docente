package upeu.g1.rest.legajo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import upeu.g1.rest.legajo.entity.Archivo;
import upeu.g1.rest.legajo.entity.Legajo;

public interface ArchivoService {

	public Iterable<Archivo> findAll();
	
	//public Page<Archivo> findAll(Pageable pageable);
	
	//public Optional<Archivo> findById(Long id);
	
	//public List<Archivo> listAllArchivo();
	
	public Archivo getArchivo(Long id);
	
	public Archivo createArchivo(Archivo archivo);
	
	public Archivo save(Archivo archivo);
	
	public Archivo deleteArchivo(Long id);
	
	public List<Archivo> findByLegajo(Legajo legajo);
	
	public Archivo updateArchivo(Archivo archivo);
	
}
